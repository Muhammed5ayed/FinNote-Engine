package app.test.p4;

import com.finnote.engine.function.mathMethod.MathEngineMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    MathEngineMethod engine() {
        return new MathEngineMethod();
    }
}
