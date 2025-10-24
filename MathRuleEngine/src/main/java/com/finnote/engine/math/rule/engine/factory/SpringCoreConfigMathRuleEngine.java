package com.finnote.engine.math.rule.engine.factory;

import com.finnote.engine.math.rule.engine.MathRuleEngine;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

@Configuration
public class SpringCoreConfigMathRuleEngine implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext() instanceof ConfigurableApplicationContext context) {
            Map<String, MathRuleEngine> engines = context.getBeansOfType(MathRuleEngine.class);
            ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
            engines.forEach((name, mathEngineMethod) -> mathEngineMethod.init(beanFactory, name));
        }
    }
}
