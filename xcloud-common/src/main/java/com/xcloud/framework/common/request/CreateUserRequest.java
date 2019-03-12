package com.xcloud.framework.common.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author administered
 * @Description
 * @Date 2018/9/1 20:33
 **/
public class CreateUserRequest implements Serializable {

    private static final long serialVersionUID = -1906123328209750887L;


    @NotBlank(message = "用户名不能为空")
    @Pattern(message = "用户名必须是3~20位数字字母的组合", regexp = "[A-Za-z0-9]{3,20}")
    private String username;


    @NotBlank(message = "密码不能为空")
    @Length(message = "密码必须是{min}~{max}位字符", min = 6, max = 20)
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
