package app.functions.S;

import com.finnote.engine.function.mathMethod.MathFunction;
import com.finnote.engine.function.mathMethod.MathFunctions;

//@Configuration
@MathFunctions(engineNames = {"engineBean","engineRegister"})
public class SampleMath2 {

    @MathFunction
    public double b(double a, double b) {
        return a + b;
    }
}
