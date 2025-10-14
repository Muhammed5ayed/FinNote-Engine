package app.smart.rule.engine.rule;

import app.smart.rule.engine.graph.RuleFlowEngine;
import app.smart.rule.engine.graph.RuleTask;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.ConversionService;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class RuleMethod extends RuleTask {
    private final Object object;
    private final Method method;

    public RuleMethod(Object returnValue, Object[] parameters, Object object, Method method) {
        super(returnValue, parameters);
        this.object = object;
        this.method = method;
        this.method.setAccessible(true);
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public Object invoke(Map<Object, Object> map, Map<Object, RuleTask> steps, ConversionService service, RuleFlowEngine engine) {
        Object[] parameters = new Object[getRequiredRules().length];
        int index = 0;
        for (Object key : getRequiredRules()) {
            parameters[index] = service.convert(map.get(key), method.getParameters()[index].getType());
            index++;
        }
        return invoke(parameters);
    }

    public Object invoke(Object[] parameters) {
        try {
            return method.invoke(getObject(), parameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static RuleTask[] scan(Object object) {
        ArrayList<RuleTask> methods = new ArrayList<>();
        Class<?> clazz = object.getClass();
        Stream.concat(Arrays.stream(clazz.getDeclaredMethods()), Arrays.stream(clazz.getMethods())).distinct().forEach(method -> {
            RuleTask builder = builder(object, method);
            if (builder != null) {
                methods.add(builder);
            }
        });
        return methods.toArray(new RuleTask[0]);
    }

    private static Object getKey(AnnotatedElement element, String name) {
        Rule annotation = AnnotationUtils.findAnnotation(element, Rule.class);
        if (annotation == null) return null;
        return (annotation.value().isBlank()) ? name : annotation.value();
    }

    public static RuleTask builder(Object object, Method method) {
        if (method.getParameterCount() == 0 && RuleTask.class.isAssignableFrom(method.getReturnType())){
            try {
                method.setAccessible(true);
                return (RuleTask) method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                return null;
            }
        }
        Object key = getKey(method, method.getName());
        if (key == null) return null;
        boolean allKeys = Arrays.stream(method.getParameters()).allMatch(parameter -> AnnotationUtils.findAnnotation(parameter, Rule.class) != null);
        if (!allKeys) return null;
        Object[] parameters = Arrays.stream(method.getParameters()).map(parameter -> getKey(parameter, parameter.getName())).toArray();
        if (Arrays.stream(parameters).anyMatch(role -> role == key)) {
            return null;
        }
        return new RuleMethod(key, parameters, object, method);
    }

}
