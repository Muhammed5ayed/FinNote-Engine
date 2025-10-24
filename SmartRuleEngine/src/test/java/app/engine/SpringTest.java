package app.engine;

import com.finnote.engine.smart.rule.engine.rule.RuleFlowException;
import com.finnote.engine.smart.rule.engine.rule.RuleFlowEngineMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringTest {
    @Autowired
    ConfigurableApplicationContext context;

    @Test
    void a() {
        RuleFlowEngineMethod engine = context.getBean("engine", RuleFlowEngineMethod.class);
        Assertions.assertNotNull(engine);
        Map<Object,Object> memory = new HashMap<>();
        memory.put("b",2);
        memory.put("c",3);
        try {
            Object a = engine.call(memory, "a");
            System.out.println(a);
        } catch (RuleFlowException e) {
            throw new RuntimeException(e);
        }

    }

}
