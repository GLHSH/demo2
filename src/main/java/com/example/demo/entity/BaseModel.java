package com.example.demo.entity;


import java.util.List;

public class BaseModel<T> {
    int code;
    String message;

    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public BaseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
