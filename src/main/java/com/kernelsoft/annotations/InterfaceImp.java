package com.kernelsoft.annotations;

public class InterfaceImp implements Interface{
    @Override
    public void walk() {
        System.out.println("method invoked");
    }
}
