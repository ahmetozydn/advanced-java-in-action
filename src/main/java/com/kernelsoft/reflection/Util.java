package com.kernelsoft.reflection;

import java.lang.annotation.Annotation;

public class Util implements FunctionalInterface{
    public String name;
    public Integer age;

    Util(int age){
        this.age = age;
    }
    Util(){}

    @Deprecated
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
