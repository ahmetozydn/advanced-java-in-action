package com.kernelsoft.annotations;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {


        LogBeforeAndAfter proxy = (LogBeforeAndAfter) Proxy.newProxyInstance(
                LogBeforeAndAfter.class.getClassLoader(),
                new Class[]{LogBeforeAndAfter.class},
                new LogHandler(new InterfaceImp()));


    }


}

