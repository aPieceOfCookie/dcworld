package com.dc.dcworld.utils.http;

import lombok.Data;

/**
 * 一个统一的结果封装工具栏里
 * @author Dell
 */
@Data
public class DcHttp<T> {
    /**
     * 状态码
     */
    private Long code;
    /**
     * 消息
     */
    private String message;
    //数据
    private T data;

    protected DcHttp() {

    }

    protected DcHttp(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功什么都不用返回
     * @param <T>
     * @return
     */
    public static <T> DcHttp<T> success() {
        return new DcHttp<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> DcHttp<T> success(T data) {
        return new DcHttp<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> DcHttp<T> success(T data, String message) {
        return new DcHttp<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> DcHttp<T> failed(ResultCode errorCode) {
        return new DcHttp<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> DcHttp<T> failed(String message) {
        return new DcHttp<T>(ResultCode.FAILURE.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> DcHttp<T> failed() {
        return failed(ResultCode.FAILURE);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> DcHttp<T> validateFailed() {
        return failed(ResultCode.PARAMS_IS_INVALID);
    }
}
