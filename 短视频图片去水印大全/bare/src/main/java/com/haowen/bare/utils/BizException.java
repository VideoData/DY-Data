package com.haowen.bare.utils;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1346416430390508752L;
    private int code;

    public BizException(ErrorCode errorCode) {
        super(errorCode.msg());
        this.code = errorCode.value();
    }

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(int code, Throwable t) {
        super(t);
        this.code = code;
    }

    public BizException(int code, String msg, Throwable t) {
        super(msg, t);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
