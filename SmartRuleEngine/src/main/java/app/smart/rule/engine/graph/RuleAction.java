package app.smart.rule.engine.graph;

import org.springframework.core.convert.ConversionService;

import java.util.Map;

/**
 * RuleAction interface used for trace or change solve value in RuleFlowEngine
 * @param <E> extends RuleTask
 */
public interface RuleAction<E extends RuleTask> {
   public Object call(Map<Object, Object> map, Map<Object, RuleTask> steps, E rule, Object keyRule, Object invoke, ConversionService service, RuleFlowEngine engine);
}
