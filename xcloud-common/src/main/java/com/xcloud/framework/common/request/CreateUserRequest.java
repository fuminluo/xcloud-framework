package com.xcloud.framework.common.request;

import java.io.Serializable;

/**
 * @Author administered
 * @Description
 * @Date 2018/9/1 20:33
 **/
public class CreateUserRequest implements Serializable {

    private static final long serialVersionUID = -1906123328209750887L;


    private String username;

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
