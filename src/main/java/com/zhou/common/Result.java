package com.zhou.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    private int code;

    private T data;

    private String message;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, data, "操作成功");
    }

    public static <T> Result<T> faild(int code, String message) {
        return new Result<>(code, null, message);
    }
}
