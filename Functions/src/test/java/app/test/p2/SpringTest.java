package app.test.p2;

import com.finnote.engine.function.factory.SpringCoreConfigFunctions;
import com.finnote.engine.function.mathMethod.MathEngineMethod;
import com.finnote.engine.function.mathMethod.MathMethod;
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
