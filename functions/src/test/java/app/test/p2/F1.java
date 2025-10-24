package app.test.p2;

import com.finnote.engine.function.mathMethod.MathFunctions;

@MathFunctions(engineNames = {"engine"})
public class F1 {
    @MathFunctions
    double cos() {
        return 0;
    }
}
