package app.engine;

import com.finnote.engine.smart.rule.engine.rule.RuleFlowEngineMethod;
import com.finnote.engine.smart.rule.engine.rule.Rule;
import com.finnote.engine.smart.rule.engine.rule.Rules;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
@Rules(engineNames = {"engine"})
class configRules {

    @Rule("a")
    public double a(@Rule("b") double b, @Rule("c") double c) {
        return b + c;
    }


    @Bean("engine")
    RuleFlowEngineMethod engine(ConversionService service) {
        return new RuleFlowEngineMethod(service);
    }
}
