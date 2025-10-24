package app.test.p3.engine1;

import com.finnote.engine.function.mathMethod.MathFunction;
import com.finnote.engine.function.mathMethod.MathFunctions;

@MathFunctions()
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
