package com.xcloud.framework.common.exception;

/**
 * @Description: 自定义异常
 * @author: administered
 * @date: 2019/3/12
 */
public class XcloudBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;


    public XcloudBaseException() {

    }

    public XcloudBaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
