package com.kernelsoft.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface

LogBeforeAndAfter {
    boolean printClassName() default true;

    boolean printMethodName() default true;

}
