package app.functions.mathMethod;

import app.spring.utility.SpringUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.ConversionService;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

// ال engine المسئول عن تجميع وتنفيذ الوظائف
public class MathEngineMethod {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ArrayList<MathMethod> list = new ArrayList<>();

    /**
     * add {@link MathMethod} in {@code this}<br>
     * Not allowed to add similar function
     *
     * @param method
     * @return is added
     */
    public boolean add(MathMethod method) {
        if (method == null) return false;
        if (!contains(method)) {
            return list.add(method);
        }
        return false;
    }

    /**
     * loads all {@link Method} is take @{{@link MathFunction}} from {@code object} for adding to this
     *
     * @param object
     */
    public void add(Object object) {
        Class<?> clazz = object.getClass();
        Stream.concat(Arrays.stream(object.getClass().getDeclaredMethods()), Arrays.stream(clazz.getMethods())).distinct().forEach(method -> {
            MathFunction annotation = AnnotationUtils.findAnnotation(method, MathFunction.class);
            if (annotation != null) {
                method.setAccessible(true);
                String name = (annotation.value() == null || annotation.value().isBlank()) ? method.getName() : annotation.value();
                add(new MathMethod(object, name, method));
            }
        });
    }

    /**
     * Add a {@link MathMethod} in a specific location.
     *
     * @param index  location
     * @param method
     */
    public void add(int index, MathMethod method) {
        if (method == null) return;
        if (!contains(method))
            list.add(index, method);
    }

    /**
     * Fast deletion of the {@link MathMethod}
     *
     * @param index location
     * @return
     */
    public MathMethod remove(int index) {
        return list.remove(index);
    }

    // احضار الوظيفة التى فى الموضع المحدد
    public MathMethod get(int index) {
        return list.get(index);
    }

    // احضار الوظيفة ذات الاسم المحدد ويمكنه ان تنفذ مع هذه المعاملات
    public MathMethod get(String name, Object[] parameters, ConversionService service) {
        for (MathMethod method : list) {
            if (method.getName().equals(name) && method.canInvoke(parameters)) {
                return method;
            }
        }

        if (service == null) return null;

        for (MathMethod method : list) {
            if (method.getName().equals(name) && method.canInvoke(parameters, service)) {
                return method;
            }
        }

        return null;
    }

    public MathMethod get(String name, Class[] parameterTypes) {
        for (MathMethod method : list) {
            if (method.getName().equals(name) && Arrays.equals(method.getMethod().getParameterTypes(), parameterTypes)) {
                return method;
            }
        }

        return null;
    }

    // عدد الوظائف الموجودة فى ال engine حاليا
    public int size() {
        return list.size();
    }

    // هل لا يوجد وظائف
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // هل هذه الوظيفة مسجله
    public boolean contains(MathMethod method) {
        MathMethod mathMethod1 = get(method.getName(), method.getMethod().getParameterTypes());
        return mathMethod1 != null;
    }

    // تبديل وظيفية بوظيفة اخرى طبقا للموضع
    public MathMethod set(int index, MathMethod element) {
        if (element == null) return null;
        if (!contains(element))
            return list.set(index, element);
        else {
            MathMethod mathMethod = get(index);
            if (element.getName().equals(mathMethod.getName()) && Arrays.equals(element.getMethod().getParameterTypes(), mathMethod.getMethod().getParameterTypes())) {
                return list.set(index, element);
            }
        }
        return null;
    }

    // تحميل الوظائف من ال application context
    public void init(ConfigurableListableBeanFactory context, String name, String packagePath) {
        Map<String, Object> beans = context.getBeansWithAnnotation(MathFunctions.class);

        beans.forEach((MathFunctionsName, bean) -> {
            MathFunctions annotation = SpringUtilities.getAnnotation(MathFunctions.class, bean, context.getBeanDefinition(MathFunctionsName));
            if (annotation != null) {
                if (packagePath != null && annotation.add()) {
                    String PackagePath = SpringUtilities.getPackage(MathFunctionsName, context);
                    if (PackagePath.startsWith(packagePath)) {
                        add(bean);
                        return;
                    }
                }

                if (Arrays.asList(annotation.engineNames()).contains(name)) {
                    add(bean);
                    return;
                }

                for (String s : annotation.regexScan()) {
                    if (name.matches(s)) {
                        add(bean);
                        return;
                    }
                }
            }
        });

    }


}
