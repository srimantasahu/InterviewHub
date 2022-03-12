package com.kvvssut.interviews.java.annotations.advanced;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)        // cannot be applied on class level, compiler restricts it
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

    String author() default "Srimanta Sahu";

    String date();

    int version() default 1;

    String comments();
}
