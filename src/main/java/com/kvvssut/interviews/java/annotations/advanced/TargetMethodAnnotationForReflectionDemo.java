package com.kvvssut.interviews.java.annotations.advanced;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TargetMethodAnnotationForReflectionDemo {

	public static void main(String[] args) {
		TargetMethodAnnotationForReflection targetMethodClass = new TargetMethodAnnotationForReflection();

		// targetMethodClass.customAnnotationDemoMethod("The version of method is : ",
		// 3); // below code does the same thing in reflection

		TargetMethod annotation = targetMethodClass.getClass().getAnnotation(
				TargetMethod.class);

		try {
			Method targetMethod = targetMethodClass.getClass().getMethod(
					annotation.targetMethod(),
					new Class[] { String.class, int.class }); // Integer.class
																// is not
																// applicable
																// here, it must
																// match with
																// the method
																// parameters

			try {
				targetMethod.invoke(targetMethodClass, new Object[] {
						"The version of method is : ", 3 });
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}
