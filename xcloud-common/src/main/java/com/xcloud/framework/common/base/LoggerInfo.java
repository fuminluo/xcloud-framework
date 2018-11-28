package com.xcloud.framework.common.base;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author LuoFuMin
 * @data 2018/8/7
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoggerInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timestamp;
    private Long duration;
    private String taskuuid;
    private String url;
    private String method;
    private Object parameters;
    private String sessionId;
    private Object resultInfo;

    public LoggerInfo() {
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getTaskuuid() {
        return this.taskuuid;
    }

    public void setTaskuuid(String taskuuid) {
        this.taskuuid = taskuuid;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getParameters() {
        return this.parameters;
    }

    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Object getResult() {
        return this.resultInfo;
    }

    public void setResult(Object result) {
        this.resultInfo = result;
    }
}


