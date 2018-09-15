package com.xcloud.framework.common.request;


import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 分页
 *
 * @author LuoFuMin
 * @data 2018/8/31
 */
public class BasePage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Min(1)
    public Integer page = 1;

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
