package app.test.p3.engine1;

import app.functions.mathMethod.MathEngineMethod;
import app.functions.mathMethod.MathFunction;
import app.functions.mathMethod.MathFunctions;

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
