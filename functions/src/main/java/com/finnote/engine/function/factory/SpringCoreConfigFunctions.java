package com.finnote.engine.function.factory;

import com.finnote.engine.function.mathMethod.MathEngineMethod;
import com.finnote.engine.function.mathMethod.MathFunctions;
import com.finnote.engine.utility.SpringUtilities;
import com.finnote.engine.function.mathMethod.MathMethod;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * It gives an order to all {@link MathEngineMethod} to make a scan of the {@link org.springframework.context.ApplicationContext} to add the target {@link MathMethod} for each {@link MathEngineMethod}.
 */
@Configuration
public class SpringCoreConfigFunctions implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext() instanceof ConfigurableApplicationContext context) {
            Map<String, MathEngineMethod> engines = context.getBeansOfType(MathEngineMethod.class);
            ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
            engines.forEach((name, mathEngineMethod) -> {
                MathFunctions annotation = SpringUtilities.getAnnotation(MathFunctions.class, beanFactory, beanFactory.getBeanDefinition(name));
                if (annotation == null)
                    mathEngineMethod.init(beanFactory, name, null);
                else
                    mathEngineMethod.init(beanFactory, name, SpringUtilities.getPackage(name, beanFactory));
            });
        }

    }
}
