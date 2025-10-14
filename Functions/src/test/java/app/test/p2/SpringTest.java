package app.test.p2;

import app.functions.factory.SpringCoreConfigFunctions;
import app.functions.mathMethod.MathEngineMethod;
import app.functions.mathMethod.MathMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Config.class, SpringCoreConfigFunctions.class})
public class SpringTest {
    @Autowired
    MathEngineMethod engineMethod;

    @Test
    void test() {
        MathMethod mathMethod = engineMethod.get("cos", new Class[]{});
        Assertions.assertNull(mathMethod);
    }
}
