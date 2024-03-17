package com.kernelsoft.generics;

public class Gen2 <T extends Number>{

    T data;

    public Gen2(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
