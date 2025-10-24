package app.test.p4;

import com.finnote.engine.function.mathMethod.MathFunction;
import com.finnote.engine.function.mathMethod.MathFunctions;
import org.springframework.stereotype.Component;

@MathFunctions(engineNames = {"engine"})
@Component
public class Triangle {
    @MathFunction
    double cos(double cos) {
        return Math.cos(cos);
    }
    @MathFunction
    double sin(double sin) {
        return Math.sin(sin);
    }
    @MathFunction
    double tan(double tan) {
        return Math.tan(tan);
    }
}