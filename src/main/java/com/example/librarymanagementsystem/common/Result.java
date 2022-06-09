package com.example.librarymanagementsystem.common;

import lombok.Data;

@Data
public class Result<T> {
    private boolean success = true;
    private int code;
    private String message;
    private T data;

    public Result(ErrorStatus status) {
        this.message = status.getMessage();
        this.code = status.getCode();
    }

    public Result(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public Result(int code, String message, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public Result<T> fail() {
        success = false;
        return this;
    }
}
