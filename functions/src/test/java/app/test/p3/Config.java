package app.test.p3;

import com.finnote.engine.function.mathMethod.MathEngineMethod;
import com.finnote.engine.function.mathMethod.MathFunctions;
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
