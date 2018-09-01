package com.xcloud.framework.service.impl;

import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.entity.User;
import com.xcloud.framework.mapper.UserMapper;
import com.xcloud.framework.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoServiceImpl 类
 *
 * @Author administered
 * @Description
 * @Date 2018/9/1 14:57
 **/
@Service
public class DemoServiceImpl implements DemoService {


    @Autowired
    UserMapper userMapper;

    @Override
    public User save(CreateUserRequest createUser) {

        userMapper.findAll();

        User user = new User();
        user.setUsername(createUser.getUsername());
        user.setPassword(createUser.getPassword());

        return user;
    }
}
