package com_xpu.domain.entity;

import lombok.Data;

@Data
public class Result<T> {
    private int code;       // 状态码
    private String message; // 返回消息
    private T data;         // 数据

    // 默认构造方法
    public Result() {}

    // 带参数的构造方法
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法，用于快速创建Result对象
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, message, data);
    }


    public static <T> Result<T> error(String message) {
        return new Result<>(0, message, null);
    }

}
