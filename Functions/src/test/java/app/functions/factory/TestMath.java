package app.functions.factory;

import app.functions.mathMethod.MathEngineMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;

import java.awt.*;

@SpringBootTest
public class TestMath {
    @Autowired
    ConfigurableApplicationContext context;

//    @Test
    void a() {
        ConversionService conversion = context.getBean(ConversionService.class);
        Assertions.assertNotNull(conversion);
        Assertions.assertNotNull(context.getBean("engineBean"));
        Assertions.assertNotNull(context.getBean("engineRegister"));

        Object[] parameters = {(double) 2, (double) 6};

        MathEngineMethod engineBean = context.getBean("engineBean", MathEngineMethod.class);
        Assertions.assertNotNull(engineBean.get("a",parameters,conversion));
        Assertions.assertNotNull(engineBean.get("b",parameters,conversion));
        Assertions.assertEquals(Double.valueOf(8), engineBean.get("a",parameters,conversion).invoke(parameters,conversion));
        Assertions.assertEquals(Double.valueOf(8), engineBean.get("b",parameters,conversion).invoke(parameters,conversion));

        MathEngineMethod engineRegister = context.getBean("engineRegister", MathEngineMethod.class);
        Assertions.assertNotNull(engineRegister.get("a",parameters,conversion));
        Assertions.assertNotNull(engineRegister.get("b",parameters,conversion));
        Assertions.assertEquals(Double.valueOf(8), engineRegister.get("a",parameters,conversion).invoke(parameters,conversion));
        Assertions.assertEquals(Double.valueOf(8), engineRegister.get("b",parameters,conversion).invoke(parameters,conversion));

    }

}
