package app.test.p4;

import app.functions.mathMethod.MathEngineMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    MathEngineMethod engine() {
        return new MathEngineMethod();
    }
}
