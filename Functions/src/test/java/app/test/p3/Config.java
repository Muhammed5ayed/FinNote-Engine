package app.test.p3;

import app.functions.mathMethod.MathEngineMethod;
import app.functions.mathMethod.MathFunctions;
import app.test.p3.engine1.Triangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    @MathFunctions
    MathEngineMethod engineMethod() {
        return new MathEngineMethod();
    }

    @Bean
    Triangle triangle() {
        return new Triangle();
    }
}
