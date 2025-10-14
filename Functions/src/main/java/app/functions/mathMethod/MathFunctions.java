package app.functions.mathMethod;

import org.intellij.lang.annotations.Language;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MathFunctions {
    @Language("spring-bean-name") String[] engineNames() default {};

    @Language("RegExp") String[] regexScan() default {};

    boolean add() default true;
}
