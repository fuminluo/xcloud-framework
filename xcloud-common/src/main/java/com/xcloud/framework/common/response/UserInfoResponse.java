package com.xcloud.framework.common.response;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:53
 **/
public class UserInfoResponse implements Serializable {

    //private static final long serialVersionUID = 548574427498754863L;

    private Long id;

    private String username;

    private String nickname;

    private String phone;

    private String photo;

    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
