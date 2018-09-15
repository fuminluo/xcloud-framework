package com.xcloud.framework.service.impl;

import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.common.response.UserInfoResponse;
import com.xcloud.framework.entity.User;
import com.xcloud.framework.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:14
 **/
@Service
public class UserServiceImpl implements UserService {


    @Override
    @Transactional
    public User save(CreateUserRequest createUser) {
        User user = new User();
        user.setUsername(createUser.getUsername());
        user.setPassword(createUser.getPassword());
        return user;
    }

    @Override
    public UserInfoResponse findUserInfoById(Long id) {
        return null;
    }
}
