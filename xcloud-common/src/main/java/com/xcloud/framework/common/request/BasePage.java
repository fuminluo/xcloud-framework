package com.xcloud.framework.common.request;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 分页
 *
 * @author administered
 * @data 2018/8/31
 */
public class BasePage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Min(value = 1, message = "起始页必须大于1")
    public Integer page = 1;

    @Max(value = 200, message = "单页最大不能超过200行")
    public Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
