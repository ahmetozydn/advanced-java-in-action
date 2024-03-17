package com.kernelsoft.generics;

public class Gen<T> {
    T data;

    public Gen(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
