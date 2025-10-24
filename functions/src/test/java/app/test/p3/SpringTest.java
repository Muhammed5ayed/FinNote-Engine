package app.test.p3;

import com.finnote.engine.function.factory.SpringCoreConfigFunctions;
import com.finnote.engine.function.mathMethod.MathEngineMethod;
import com.finnote.engine.function.mathMethod.MathMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Config.class, SpringCoreConfigFunctions.class})
public class SpringTest {

    @Autowired
    MathEngineMethod engineMethod;

    @Test
    @DisplayName("test triangle")
    void a() {
        MathMethod sin = engineMethod.get("sin", new Class[]{double.class});
        Assertions.assertNotNull(sin);
        Assertions.assertEquals(Math.sin(22), sin.invoke(new Object[]{22}, null));
        MathMethod cos = engineMethod.get("cos", new Class[]{double.class});
        Assertions.assertNotNull(cos);
        Assertions.assertEquals(Math.cos(22), cos.invoke(new Object[]{22}, null));
        MathMethod tan = engineMethod.get("tan", new Class[]{double.class});
        Assertions.assertNotNull(tan);
        Assertions.assertEquals(Math.tan(22), tan.invoke(new Object[]{22}, null));

    }
}
