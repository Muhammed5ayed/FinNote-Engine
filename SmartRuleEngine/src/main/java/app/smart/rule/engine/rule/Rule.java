package app.smart.rule.engine.rule;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER})
public @interface Rule {
    String value() default "";
}
