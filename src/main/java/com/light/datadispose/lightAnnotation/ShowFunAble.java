package com.light.datadispose.lightAnnotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要显示的功能组或功能注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ShowFunAble {

    /**
     * 功能组或功能描述
     *
     */
    String description() default "";

    /**
     * 功能组或功能名称
     *
     */
    String name();

}
