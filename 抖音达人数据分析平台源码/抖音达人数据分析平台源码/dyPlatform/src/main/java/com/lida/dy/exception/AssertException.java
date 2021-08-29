package com.lida.dy.exception;

/**
 * 业务中的断言异常
 *
 * @Auther: lida
 * @Description:
 * @Date 2020/1/10 0010 11:02
 * @Version: 1.0
 */
public class AssertException extends RuntimeException {
    private String message;

    public AssertException(String message) {
        this.message = message;
    }

    public AssertException(String message, AssertMessageEnum assertMessageEnum) {
        this.message = message + assertMessageEnum.getMessage();
    }

}
