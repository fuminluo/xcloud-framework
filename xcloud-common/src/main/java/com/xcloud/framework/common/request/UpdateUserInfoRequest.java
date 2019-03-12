package com.xcloud.framework.common.request;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author: administered
 * @date: 2019/3/12
 */
public class UpdateUserInfoRequest extends IdRequest implements Serializable {
    private static final long serialVersionUID = -6272073881457078842L;

    private String nickname;

    private String phone;

    private String photo;

    @Email
    private String email;

    private String sex;

    @Max(200)
    private Integer age;

    private String address;

    private Date birthday;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
