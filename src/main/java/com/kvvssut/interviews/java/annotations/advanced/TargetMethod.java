package com.kvvssut.interviews.java.annotations.advanced;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetMethod {

	String targetMethod();

	int version() default 1;
}
