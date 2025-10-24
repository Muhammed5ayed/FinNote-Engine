package app.test.p1;

import com.finnote.engine.function.factory.SpringCoreConfigFunctions;
import com.finnote.engine.function.mathMethod.MathEngineMethod;
import com.finnote.engine.function.mathMethod.MathMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;


@SpringBootTest(classes = {Config.class, SpringCoreConfigFunctions.class, Triangle.class})
@Configuration
class SpringTest {


    @Autowired
    MathEngineMethod engineMethod;


    @Test
    @DisplayName("test-cos")
    void contextLoads() {
        MathMethod mathMethod = engineMethod.get("cos", new Class[]{double.class});
        Assertions.assertNotNull(mathMethod, "must be cos function");
        Object invoke = mathMethod.invoke(new Object[]{14d}, null);
        Assertions.assertEquals(0.1367372182078336d, invoke);
    }
}
