package app.test.p1;

import app.functions.mathMethod.MathEngineMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    MathEngineMethod engineMethod = new MathEngineMethod();

    @Bean
    MathEngineMethod engineMethod() {
        return engineMethod;
    }
}
