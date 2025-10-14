package app.test.p1;

import app.functions.mathMethod.MathFunction;
import app.functions.mathMethod.MathFunctions;
import org.springframework.stereotype.Component;

@Component
@MathFunctions(engineNames = {"engineMethod"})
public class Triangle {
    @MathFunction
    double cos(double value) {
        return Math.cos(value);
    }
}
