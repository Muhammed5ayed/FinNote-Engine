package app.test.p4;

import app.functions.factory.SpringCoreConfigFunctions;
import app.functions.mathMethod.MathEngineMethod;
import app.functions.mathMethod.MathMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Config.class, SpringCoreConfigFunctions.class, Triangle.class})
public class SpringTest {
    @Autowired
    MathEngineMethod engine;

    @Test
    void a() {
        MathMethod cos = engine.get("cos", new Class[]{double.class});
        Assertions.assertNotNull(cos);
        Assertions.assertEquals(Math.cos(22), cos.invoke(new Object[]{22}, null));

        MathMethod sin = engine.get("sin", new Class[]{double.class});
        Assertions.assertNotNull(sin);
        Assertions.assertEquals(Math.sin(22), sin.invoke(new Object[]{22}, null));


        MathMethod tan = engine.get("tan", new Class[]{double.class});
        Assertions.assertNotNull(tan);
        Assertions.assertEquals(Math.tan(22), tan.invoke(new Object[]{22}, null));

    }
}
