package com.kernelsoft.annotations;

public class Util {
    public void before() {
        System.out.println("before annotation function");
    }


    @LogBeforeAndAfter()
    public void annotationFunction() {
        System.out.println("inside annotation function");
    }

    public void after() {
        System.out.println("after annotation function");
    }
}
