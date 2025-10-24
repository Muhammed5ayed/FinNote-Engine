package com.finnote.engine.smart.rule.engine.rule;

import org.intellij.lang.annotations.Language;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
/**
 * this method used for scan any methods inside class
 */
public @interface Rules {
    @Language("spring-bean-name") String[] engineNames() default {};

    @Language("RegExp") String[] regexScan() default {};

    boolean add() default true;

}
