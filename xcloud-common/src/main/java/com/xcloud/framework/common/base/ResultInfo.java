package com.xcloud.framework.common.base;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回模板
 *
 * @author LuoFuMin
 * @data 2018/8/31
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultInfo<T> {

    public static final Integer SUCCESS = 200;

    public static final Integer FAIL = 400;

    public static final Integer ERROR = 500;

    public static final String MSG_SUCCESS = "执行成功";

    public static final String MSG_FAIL = "执行失败";

    public static final String MSG_ERROR = "发生错误";

    private Integer code;
    private String message;
    private Long timestamp;
    private T data;


    public static ResultInfo<?> OK(Object obj) {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, obj);
    }

    public static ResultInfo<?> FALL() {
        return new ResultInfo<>(ResultInfo.FAIL, ResultInfo.MSG_FAIL);
    }

    public ResultInfo(Integer code, String message) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    public ResultInfo(Integer code, String message, T data) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
