package com.lw.springcloud.program.entity;

import lombok.Data;

/**
 * @author lw
 * @create 2021-02-25-9:37
 */
@Data
public class Relust<T> {

     private T data;

     private String message;

     private int code;



    public Relust(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Relust(String message, Integer code) {
        this(null, message, code);
    }

    public Relust(T data) {
        this(data, "操作成功", 200);
    }
}
