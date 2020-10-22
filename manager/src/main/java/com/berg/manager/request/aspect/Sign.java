package com.berg.manager.request.aspect;

import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Order(1)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sign {

    String value() default "";
}
