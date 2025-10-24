package app.p1;

import app.p1.ann.An1;
import app.p1.ann.An2;
import app.p1.component.SampleComponent;
import app.p1.component.SampleConfig;
import com.finnote.engine.utility.SpringUtilities;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.annotation.Annotation;

@SpringBootTest(classes = {SampleComponent.class, Config.class, SampleConfig.class})
class SpringTest {
    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        Assertions.assertInstanceOf(ConfigurableApplicationContext.class, context);
        ConfigurableListableBeanFactory factory = ((ConfigurableApplicationContext) context).getBeanFactory();


        Class<? extends Annotation> annotation = An1.class;
        String name = "sampleComponent";
        Assertions.assertNotNull(SpringUtilities.getAnnotation(annotation, factory.getBean(name), factory.getBeanDefinition(name)));

        name = "sampleBean";
        Assertions.assertNotNull(SpringUtilities.getAnnotation(annotation, factory.getBean(name), factory.getBeanDefinition(name)));

        name = "sampleConfig";
        Assertions.assertNotNull(SpringUtilities.getAnnotation(annotation, factory.getBean(name), factory.getBeanDefinition(name)));


        annotation = An2.class;
        name = "sampleComponent";
        Assertions.assertNotNull(SpringUtilities.getAnnotation(annotation, factory.getBean(name), factory.getBeanDefinition(name)));

        name = "sampleBean";
        Assertions.assertNotNull(SpringUtilities.getAnnotation(annotation, factory.getBean(name), factory.getBeanDefinition(name)));

        name = "sampleConfig";
        Assertions.assertNotNull(SpringUtilities.getAnnotation(annotation, factory.getBean(name), factory.getBeanDefinition(name)));


    }


}
