package com.kvvssut.interviews.java.annotations.advanced;

public class MethodInfoAnnotationDemo {

    public static void main(String[] args) {
        customAnnotationDemoMethod("Inside custom annotation demo method!!", 5);
    }

    @MethodInfo(version = 2, date = "04-Nov-2015", comments = "Demo method")
    public static void customAnnotationDemoMethod(String methodName, int trial) {
        System.out.println(methodName + "\tTrail version : " + trial);
    }

}
