package app.functions.mathMethod;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.ConversionService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class MathMethod {
    private final Object object;
    private final String name;
    private final Method method;

    public MathMethod(Object object, String name, Method method) {
        this.object = object;
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public Method getMethod() {
        return method;
    }

    public Object getObject() {
        return object;
    }

    public boolean canInvoke(Object[] parameters) {
        if (parameters.length != method.getParameterCount()) {
            return false;
        }
        int index = 0;
        for (Parameter parameter : method.getParameters()) {
            if (parameters[index++].getClass() != parameter.getType()) {
                return false;
            }
        }
        return true;
    }

    public boolean canInvoke(Object[] parameters, ConversionService service) {
        if (parameters.length != method.getParameterCount()) {
            return false;
        }
        int index = 0;
        for (Parameter parameter : method.getParameters()) {
            if (!service.canConvert(parameters[index++].getClass(), parameter.getType())) {
                return false;
            }
        }
        return true;
    }

    public Object invoke(Object[] parameters, ConversionService service) {
        Object[] to;
        if (service != null) {
            to = new Object[parameters.length];
            int index = 0;
            for (Parameter parameter : method.getParameters()) {
                to[index] = service.convert(parameters[index], parameter.getType());
                index++;
            }
        } else {
            to = parameters;
        }

        try {
            Object invoke = method.invoke(object, to);
            if (method.getReturnType() == void.class)
                invoke = Solver.Void;
            return invoke;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static MathMethod[] scan(Object object) {
        ArrayList<MathMethod> list = new ArrayList<>();
        Class<?> clazz = object.getClass();
        Stream.concat(Arrays.stream(clazz.getDeclaredMethods()), Arrays.stream(clazz.getMethods())).distinct().forEach(method -> {
            MathFunction annotation = AnnotationUtils.findAnnotation(method, MathFunction.class);
            if (annotation != null) {
                method.setAccessible(true);
                String name = (annotation.value() == null || annotation.value().isBlank()) ? method.getName() : annotation.value();
                list.add(new MathMethod(object, name, method));
            }
        });
        return list.toArray(new MathMethod[0]);
    }

    enum Solver {
        Void
    }
}
