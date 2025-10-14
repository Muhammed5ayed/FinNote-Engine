package app.test.p2;

import app.functions.mathMethod.MathFunctions;

@MathFunctions(engineNames = {"engine"})
public class F1 {
    @MathFunctions
    double cos() {
        return 0;
    }
}
