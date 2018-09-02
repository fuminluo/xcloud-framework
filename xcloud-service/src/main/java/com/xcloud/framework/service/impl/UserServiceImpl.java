package com.xcloud.framework.service.impl;

import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.common.response.UserInfoResponse;
import com.xcloud.framework.common.util.EntityUtils;
import com.xcloud.framework.dao.UserDao;
import com.xcloud.framework.entity.User;
import com.xcloud.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public User save(CreateUserRequest createUser) {
        User user = new User();
        user.setUsername(createUser.getUsername());
        user.setPassword(createUser.getPassword());
        user = userDao.save(user);
        return user;
    }

    @Override
    public UserInfoResponse findUserInfoById(Long id) {
        List<Object[]> date = userDao.findUserInfo(id);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        EntityUtils.castEntity(date, UserInfoResponse.class, userInfoResponse);
        return userInfoResponse;
    }
}
