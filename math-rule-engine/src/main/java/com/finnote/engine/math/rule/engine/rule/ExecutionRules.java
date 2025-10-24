package com.finnote.engine.math.rule.engine.rule;

import com.finnote.engine.math.rule.engine.AutoCompletion.ScanLabel;
import com.finnote.engine.math.rule.engine.LineExpression;
import com.finnote.engine.math.rule.engine.MathRuleEngine;
import com.finnote.engine.smart.rule.engine.graph.RuleFlowEngine;
import com.finnote.engine.smart.rule.engine.graph.RuleTask;
import org.springframework.core.convert.ConversionService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExecutionRules extends RuleTask {

    private final String text;
    private final boolean forget;

    public ExecutionRules(Object key, String text) {
        this(key, false, text);
    }

    public ExecutionRules(Object key, boolean forget, String text) {
        super(key, ScanLabel.getVars(text).toArray(new Object[0]));
        if (key == null) throw new RuntimeException("key must not null");
        this.text = text;
        this.forget = forget;
    }


    public String getText() {
        return text;
    }

    @Override
    public Object invoke(Map<Object, Object> map, Map<Object, RuleTask> steps, ConversionService service, RuleFlowEngine engine) {
        if (engine instanceof RuleFlowMathEngineMethod ruleFlowMathEngineMethod) {
            MathRuleEngine eng = ruleFlowMathEngineMethod.getEngine();
            Map<Object, Object> memory = eng.getMemory();
            if (forget) {
                Map<Object, Object> cloneMemory = new HashMap<>(memory);
                HashMap<Object, RuleTask> cloneSteps = new HashMap<>(eng.getSteps());
                Iterator<LineExpression> process = eng.process(text);
                while (process.hasNext()) {
                    process.next();
                }
                if (!memory.containsKey(getRule())) throw new RuntimeException();
                Object value = memory.get(getRule());
                memory.clear();
                memory.putAll(cloneMemory);
                steps.clear();
                steps.putAll(cloneSteps);
                return value;
            } else {
                Iterator<LineExpression> process = eng.process(text);
                while (process.hasNext()) {
                    process.next();
                }
                if (!memory.containsKey(getRule())) throw new RuntimeException();
                return memory.get(getRule());
            }
        }
        return null;
    }
}
