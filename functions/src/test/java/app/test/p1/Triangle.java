package app.test.p1;

import com.finnote.engine.function.mathMethod.MathFunction;
import com.finnote.engine.function.mathMethod.MathFunctions;
import org.springframework.stereotype.Component;

@Component
@MathFunctions(engineNames = {"engineMethod"})
public class Triangle {
    @MathFunction
    double cos(double value) {
        return Math.cos(value);
    }
}
