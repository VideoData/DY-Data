package com.haowen.bare.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class ReturnObject<T> implements Serializable {

    private static final long serialVersionUID = 2902854698911679014L;

    /**
     * 错误代码
     */
    private int code;

    /**
     * 返回对象
     */
    private T data;

    /**
     * 错误代码对应的信息
     */
    private String msg;

    public ReturnObject() {
    }

    /**
     * @param errorCode 统一错误代码对象
     * @param data      返回对象
     */
    public ReturnObject(ErrorCode errorCode, T data) {
        this.code = errorCode.value();
        this.data = data;
        this.msg = errorCode.msg();
    }

    /**
     * @param code 统一错误代码
     * @param data 返回对象
     * @param msg  错误代码对应的信息
     */
    public ReturnObject(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
