package com.xcloud.framework.common.request;

import io.swagger.annotations.Api;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:30
 **/
public class IdRequest implements Serializable {

    private static final long serialVersionUID = -5082880526664034160L;

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
