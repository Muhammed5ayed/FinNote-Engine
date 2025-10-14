package app.functions.S;

import app.functions.mathMethod.MathFunction;
import app.functions.mathMethod.MathFunctions;
import org.springframework.context.annotation.Configuration;

//@Configuration
@MathFunctions(engineNames = {"engineBean","engineRegister"})
public class SampleMath2 {

    @MathFunction
    public double b(double a, double b) {
        return a + b;
    }
}
