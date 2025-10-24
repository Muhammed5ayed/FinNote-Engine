package com.finnote.engine.smart.rule.engine.factory;

import com.finnote.engine.smart.rule.engine.rule.RuleFlowEngineMethod;
import com.finnote.engine.smart.rule.engine.rule.Rules;
import com.finnote.engine.utility.SpringUtilities;
import com.finnote.engine.smart.rule.engine.graph.RuleFlowEngine;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * It gives an order to all {@link RuleFlowEngineMethod} to make a scan of the {@link org.springframework.context.ApplicationContext} to add the target {@link RuleFlowEngine} for each {@link RuleFlowEngineMethod}.
 */
@Configuration
class SpringCoreConfigRole implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext() instanceof ConfigurableApplicationContext context) {
            ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
            Map<String, RuleFlowEngineMethod> beansOfType = beanFactory.getBeansOfType(RuleFlowEngineMethod.class);
            beansOfType.forEach((name, engine) -> {
                Rules annotation = SpringUtilities.getAnnotation(Rules.class, engine, beanFactory.getBeanDefinition(name));
                if (annotation == null)
                    engine.init(beanFactory, name, null);
                else {
                    engine.init(beanFactory, name, SpringUtilities.getPackage(name, beanFactory));
                }
            });
        }
    }
}
