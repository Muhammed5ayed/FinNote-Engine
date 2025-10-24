package app.functions.factory;

import com.finnote.engine.function.mathMethod.MathEngineMethod;
import com.finnote.engine.function.mathMethod.MathFunction;
import com.finnote.engine.function.mathMethod.MathFunctions;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@MathFunctions(engineNames = {"engineBean","engineRegister"})
public class SampleMath {

    @MathFunction
    public double a(double a, double b) {
        return a + b;
    }

    @Bean()
    public MathEngineMethod engineBean(){
        return new MathEngineMethod();
    }

    @Bean()
    public Object buildEngine(ConfigurableApplicationContext context) {
        context.getBeanFactory().registerSingleton("engineRegister",new MathEngineMethod());
        return null;
    }
}
