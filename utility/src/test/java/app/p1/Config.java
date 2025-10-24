package app.p1;

import app.p1.ann.An1;
import app.p1.component.SampleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    @An1
    public SampleBean sampleBean() {
        return new SampleBean();
    }
}
