package com.lida.dy.schedle.exception;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/2/1 0001 19:20
 * @Version: 1.0
 */
public class SpiderException extends Exception {


    private String message;

    public SpiderException() {
        super();
    }

    public SpiderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
