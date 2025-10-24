package com.finnote.engine.smart.rule.engine.graph;

import org.springframework.core.convert.ConversionService;
import java.util.Map;
import java.util.StringJoiner;

public abstract class RuleTask {
    private final Object rule;
    private final Object[] requiredRules;

    public RuleTask(Object rule, Object[] requiredRules) {
        this.rule = rule;
        this.requiredRules = requiredRules;
    }

    public Object getRule() {
        return rule;
    }

    public Object[] getRequiredRules() {
        return requiredRules;
    }

    @Override
    public String toString() {
        if (requiredRules != null) {
            StringJoiner joiner = new StringJoiner(",");
            for (Object role : requiredRules) {
                joiner.add(role.toString());
            }
            return joiner + " --> " + rule.toString();
        }
        return rule.toString();
    }

    public abstract Object invoke(Map<Object, Object> map, Map<Object, RuleTask> steps, ConversionService service,RuleFlowEngine engine);

    public boolean test(Map<Object, Object> map, Map<Object, RuleTask> steps, ConversionService service,RuleFlowEngine engine) {
        for (Object role : getRequiredRules()) {
            if (!map.containsKey(role) && (steps == null || !steps.containsKey(role)))
                return false;
        }
        return true;
    }
}
