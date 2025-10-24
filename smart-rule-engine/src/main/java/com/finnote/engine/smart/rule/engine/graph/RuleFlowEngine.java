package com.finnote.engine.smart.rule.engine.graph;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.ConversionService;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @param <E>
 */
public class RuleFlowEngine<E extends RuleTask> {

    private boolean sorted = false;
    private RuleAction<RuleTask> action;
    private final CopyOnWriteArrayList<E> list = new CopyOnWriteArrayList<>();
    private boolean call = true;

    public Map<Object, Object> find(@NotNull Map<Object, Object> memory, Object task, ConversionService service) {
        return find(memory, null, task, service);
    }

    public Map<Object, Object> find(@NotNull Map<Object, Object> memory, Map<Object, RuleTask> steps, Object task, ConversionService service) {

        if (steps == null)
            steps = new ConcurrentHashMap<>();
        else
            removeSteps(memory, steps);


        if (memory.containsKey(task)) {
            if (call) {
                Object value = memory.get(task);
                if (action != null)
                    value = action.call(memory, steps, null, task, value, service, this);

                memory.put(task, value);
            }
            return memory;
        }

        sort();

        for (int i = 0; i < list.size(); i++) {

            if (isFind(memory, steps, task, service))
                return memory;

            RuleTask node = list.get(i);
            if (test(memory, steps, node, service, this)) {
                if (!putStep(memory, steps, node, service))
                    return null;
                i = -1;
            }
        }
        if (isFind(memory, steps, task, service))
            return memory;
        return null;
    }

    private static boolean test(@NotNull Map<Object, Object> map, Map<Object, RuleTask> steps, RuleTask node, ConversionService service, RuleFlowEngine engine) {
        return !steps.containsKey(node.getRule())
                &&
                !map.containsKey(node.getRule())
                &&
                node.test(map, steps, service, engine);
    }

    private boolean isFind(@NotNull Map<Object, Object> map, Map<Object, RuleTask> steps, Object key, ConversionService service) {
        if (steps.containsKey(key)) {
            call(map, steps, service, key);
            return true;
        } else {
            for (RuleTask node : list) {
                if (node.getRule() == key && node.test(map, steps, service, this)) {
                    steps.put(key, node);
                    call(map, steps, service, key);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean overlappingSteps(RuleTask a, RuleTask b) {
        return Arrays.stream(a.getRequiredRules()).anyMatch(role -> role == b.getRule()) && Arrays.stream(b.getRequiredRules()).anyMatch(role -> role == a.getRule());
    }

    public static RuleTask overlappingSteps(Map<Object, RuleTask> steps, RuleTask task) {
        for (Object role : task.getRequiredRules()) {
            if (steps.containsKey(role)) {
                RuleTask n = steps.get(role);
                if (Arrays.stream(n.getRequiredRules()).anyMatch(o -> o == task.getRule()))
                    return n;
            }
        }
        return null;
    }

    private synchronized boolean putStep(Map<Object, Object> map, Map<Object, RuleTask> steps, RuleTask node, ConversionService service) {
        RuleTask n = overlappingSteps(steps, node);
        if (n == null) {
            steps.put(node.getRule(), node);
            return true;
        }
        for (E method : list) {
            if (n == method) continue;
            if (method.getRule() == n.getRule() && method.test(map, steps, service, this)) {
                if (overlappingSteps(steps, method) == null && !overlappingSteps(method, node)) {
                    steps.put(method.getRule(), method);
                    steps.put(node.getRule(), node);
                    return true;
                }
            }
        }
        return false;
    }

    protected void call(Map<Object, Object> map, Map<Object, RuleTask> steps, ConversionService service, Object keyMap) {
        if (!call) return;

        if (map.containsKey(keyMap)) {
            return;
        }

        RuleTask node = steps.get(keyMap);

        for (Object key : node.getRequiredRules()) {
            call(map, steps, service, key);
        }
        steps.remove(keyMap);

        Object invoke = node.invoke(map, steps, service, this);
        if (action != null) {
            invoke = action.call(map, steps, node, keyMap, invoke, service, this);
        }
        map.put(keyMap, invoke);
    }

    /**
     * @param action
     */
    public void setAction(RuleAction<RuleTask> action) {
        this.action = action;
    }

    /**
     * @return {@link RuleAction} for used action invoke all {@link RuleTask}
     */
    public RuleAction<RuleTask> getAction() {
        return action;
    }


    private void removeSteps(Map<Object, Object> map, Map<Object, RuleTask> steps) {
        // تحديد كل المفاتيح المشتركة بين ال steps و map
        Predicate<Map.Entry<Object, RuleTask>> commonKeys = element -> map.containsKey(element.getKey());
        // تحديد كل المفاتيح التي تتشابه مع المعاملات
        Predicate<Map.Entry<Object, RuleTask>> keysSimilarParameters = element -> Arrays.stream(element.getValue().getRequiredRules()).anyMatch(role -> role == element.getKey());
        // تحديد كل ال steps المتداخلة
        Predicate<Map.Entry<Object, RuleTask>> overlappingSteps = element -> Arrays.stream(element.getValue().getRequiredRules())
                .allMatch(roleA -> {
                    if (steps.containsKey(roleA)) {
                        return Arrays.stream(steps.get(roleA).getRequiredRules())
                                .anyMatch(roleB -> roleB == element.getKey());
                    }
                    return false;
                });
        // تحديد كل ال steps التي لا تتوفر لها بيانات
        Predicate<Map.Entry<Object, RuleTask>> incompleteDataSteps = element -> Arrays.stream(element.getValue().getRequiredRules()).allMatch(role -> map.containsKey(role) || steps.containsKey(role));


        // حذف كل ال steps المحسوبة مسبقًا و التي لا يمكن حسابها
        steps.entrySet().removeIf(commonKeys.or(incompleteDataSteps));

        // حذف كل الخطوات التي ستسبب مشاكل
        steps.entrySet().removeIf(keysSimilarParameters.or(overlappingSteps));

    }


    /**
     * @param ruleTask is {@link RuleTask} add in {@link RuleFlowEngine}
     * @return has addes
     */
    public boolean add(E ruleTask) {
        if (ruleTask == null) return false;
        if (Arrays.stream(ruleTask.getRequiredRules()).anyMatch(role -> role == ruleTask.getRule())) return false;

        sorted = false;
        return list.add(ruleTask);
    }

    /**
     * @param index remove {@link RuleTask} with {@code index}
     * @return {@link RuleTask}
     */

    public E remove(int index) {
        sorted = false;
        return list.remove(index);
    }

    /**
     * @param index index {@link RuleTask} in {@link RuleFlowEngine}
     * @return {@link RuleTask}
     */
    public E get(int index) {
        return list.get(index);
    }

    /**
     * @param index    index {@link RuleTask} in {@link RuleFlowEngine}
     * @param ruleTask is {@link RuleTask} for add in {@link RuleFlowEngine}
     * @return {@link RuleTask} is add
     */
    public E set(int index, E ruleTask) {
        sorted = false;
        return list.set(index, ruleTask);
    }

    /**
     * sort all {@link RuleTask} from the largest {@link RuleTask#getRequiredRules()} of rules to the smallest number of {@link RuleTask#getRequiredRules()}
     */
    public void sort() {
        if (!sorted) {
            list.sort((o1, o2) -> o2.getRequiredRules().length - o1.getRequiredRules().length);
            sorted = true;
        }
    }

    /**
     * @return count {@link RuleTask} in {@link RuleFlowEngine}
     */
    public int size() {
        return list.size();
    }

    /**
     * @param action forEach for loop all {@link RuleTask} in {@link RuleFlowEngine}
     */
    public void forEach(Consumer<? super E> action) {
        list.forEach(action);
    }


    /**
     * @return {@code true} means {@link RuleFlowEngine} invoke all {@link RuleTask} for solve | {@code flase} is means {@link RuleFlowEngine} solve steps only
     */
    public boolean isCall() {
        return call;
    }

    /**
     * @param call {@code true} means {@link RuleFlowEngine} invoke all {@link RuleTask}  for solve | {@code flase} is means {@link RuleFlowEngine} solve steps only
     */
    public void setCall(boolean call) {
        this.call = call;
    }


}
