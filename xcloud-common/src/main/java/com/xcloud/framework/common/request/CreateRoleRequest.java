package com.xcloud.framework.common.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:45
 **/
public class CreateRoleRequest implements Serializable {

    private static final long serialVersionUID = -6790160488329028508L;

    @NotNull
    private String name;
    @NotNull
    private String code;

    private String depict;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }
}
