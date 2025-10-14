package app.spring.utility;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;

public class SpringUtilities {
    public static <E extends Annotation> E getAnnotation(Class<E> annotation, Object bean, BeanDefinition definition) {
        if (definition.getFactoryBeanName() == null) {
            Class<?> type;
            if (definition.getResolvableType() == ResolvableType.NONE)
                type = bean.getClass();
            else
                type = definition.getResolvableType().getRawClass();

            return AnnotatedElementUtils.findMergedAnnotation(type, annotation);
        } else {
            if (definition.getSource() instanceof AnnotatedTypeMetadata obj) {
                if (obj.isAnnotated(annotation.getName()))
                    return obj.getAnnotations().get(annotation).synthesize();
                else
                    return AnnotatedElementUtils.findMergedAnnotation(bean.getClass(), annotation);
            }
        }
        return null;
    }

    public static String getPackage(String nameBean, ConfigurableListableBeanFactory context) {
        BeanDefinition definition = context.getBeanDefinition(nameBean);
        if (definition.getFactoryBeanName() == null) {
            return context.getBean(nameBean).getClass().getPackage().getName();
        }
        return context.getBean(definition.getFactoryBeanName()).getClass().getPackage().getName();
    }

    public static void setupGUI() {
        System.setProperty("java.awt.headless", "false");
    }

    public static ConfigurableApplicationContext runGui(Class<?> clazz, String... args) {
        setupGUI();
        return SpringApplication.run(clazz, args);
    }
}
