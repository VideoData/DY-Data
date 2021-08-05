package com.haowen.bare.utils;


public class ResponseUtil {

    private ResponseUtil() {
    }

    /**
     * 成功的web MVC ReturnObject对象
     *
     * @param entity 返回的业务数据
     * @return ReturnObject
     */
    public static <E> ReturnObject<E> ok(E entity) {
        return makeRo(ErrorCode.OK.value(), ErrorCode.OK.msg(), entity);
    }

    /**
     * 错误的web MVC ReturnObject对象
     */
    public static <E> ReturnObject<E> error(int code, String msg) {
        return makeRo(code, msg, null);
    }


    /**
     * 错误的web MVC ReturnObject对象
     *
     * @param ec 错误代码对象
     * @return ReturnObject
     */
    public static <E> ReturnObject<E> error(ErrorCode ec) {
        return makeRo(ec.value(), ec.msg(), null);
    }

    /**
     * 生成web MVC ReturnObject对象
     *
     * @param code   错误代码对象
     * @param msg    错误代码对象
     * @param entity 返回的业务数据
     * @return ReturnObject
     */
    private static <E> ReturnObject<E> makeRo(int code, String msg, E entity) {
        return new ReturnObject<>(code, entity, msg);
    }
}
