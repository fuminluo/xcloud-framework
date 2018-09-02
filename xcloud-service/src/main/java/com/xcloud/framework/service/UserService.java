package com.xcloud.framework.service;

import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.common.response.UserInfoResponse;
import com.xcloud.framework.entity.User;

/**
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:14
 **/
public interface UserService {

    User save(CreateUserRequest createUser);


    UserInfoResponse findUserInfoById(Long id);
}
