package app.smart.rule.engine.rule;

import app.smart.rule.engine.graph.RuleAction;
import app.smart.rule.engine.graph.RuleFlowEngine;
import app.smart.rule.engine.graph.RuleTask;
import app.spring.utility.SpringUtilities;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.convert.ConversionService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class RuleFlowEngineMethod extends RuleFlowEngine<RuleTask> {

    private final ConversionService conversionService;
    private RuleAction<RuleTask> action;

    public RuleFlowEngineMethod(ConversionService conversionService) {
        this.conversionService = conversionService;
        RuleAction<RuleTask> Superaction = (map, steps, rule, keyRule, invoke, service, engine) -> {
            if (rule instanceof RuleMethod method) {
                if (method.getMethod().getReturnType() == void.class) {
                    invoke = Solver.Void;
                }
            }
            if (action != null) {
                invoke = action.call(map, steps, rule, keyRule, invoke, service, engine);
            }
            return invoke;
        };
        super.setAction(Superaction);
    }

    public Object call(Map<Object, Object> map, Object value) throws RuleFlowException {
        Map<Object, Object> values = this.find(map, new HashMap<>(), value, conversionService);
        if (values != null)
            map.putAll(values);
        if (!map.containsKey(value)) {
            throw new RuleFlowException("can n't solve [%s]".formatted(value.toString()));
        }
        return map.get(value);
    }

    @Override
    public RuleAction<RuleTask> getAction() {
        return action;
    }

    @Override
    public void setAction(RuleAction<RuleTask> action) {
        this.action = action;
    }

    public void add(Object object) {
        for (RuleTask ruleTask : RuleMethod.scan(object)) {
            add(ruleTask);
        }
    }

    public void init(ConfigurableListableBeanFactory context, String name, String packagePath) {
        Map<String, Object> beansOfRules = context.getBeansWithAnnotation(Rules.class);
        beansOfRules.putAll(context.getBeansOfType(RuleTask.class));

        beansOfRules.forEach((beanName, bean) -> {
            Rules annotation = SpringUtilities.getAnnotation(Rules.class, bean, context.getBeanDefinition(beanName));
            if (annotation != null) {
                if (packagePath != null && annotation.add()) {
                    String aPackage = SpringUtilities.getPackage(beanName, context);
                    if (aPackage.startsWith(packagePath)) {
                        add(bean);
                        return;
                    }
                }

                if (Arrays.asList(annotation.engineNames()).contains(name)) {
                    add(bean);
                    return;
                }

                for (String r : annotation.regexScan()) {
                    if (name.matches(r)) {
                        add(bean);
                        return;
                    }
                }
            } else {
                if (packagePath != null && bean instanceof RuleTask) {
                    String aPackage = SpringUtilities.getPackage(beanName, context);
                    if (aPackage.startsWith(packagePath)) {
                        add(bean);
                        return;
                    }
                }
            }
        });
    }

    enum Solver {
        Void
    }
}
