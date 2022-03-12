package com.kvvssut.interviews.java.annotations.advanced;

@TargetMethod(targetMethod = "customAnnotationDemoMethod", version = 3)
public class TargetMethodAnnotationForReflection {

    @MethodInfo(version = 2, date = "04-Nov-2015", comments = "Demo method")
    public static void customAnnotationDemoMethod(String message, int trial) {
        System.out.println(message + trial);
    }

}
