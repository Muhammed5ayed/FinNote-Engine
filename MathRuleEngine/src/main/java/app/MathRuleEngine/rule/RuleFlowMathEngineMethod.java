package app.MathRuleEngine.rule;

import app.MathRuleEngine.MathRuleEngine;
import app.smart.rule.engine.rule.RuleFlowEngineMethod;
import app.smart.rule.engine.graph.RuleTask;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.ConversionService;

import java.util.Map;

public class RuleFlowMathEngineMethod extends RuleFlowEngineMethod {

    private final MathRuleEngine engine;


    public RuleFlowMathEngineMethod(ConversionService service, MathRuleEngine engine) {
        super(service);
        this.engine = engine;
    }

    public MathRuleEngine getEngine() {
        return engine;
    }

    @Override
    public Map<Object, Object> find(@NotNull Map<Object, Object> memory, Map<Object, RuleTask> steps, Object task, ConversionService service) {
        return super.find(memory, steps, task, service);
    }
}
