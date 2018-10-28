package com.xcloud.framework.service.impl;

import com.xcloud.framework.entity.User;
import com.xcloud.framework.mapper.UserMapper;
import com.xcloud.framework.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author administered
 * @Description
 * @Date 2018/10/28 13:46
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public int save(User user) throws Exception {
        int i = userMapper.insertSelective(user);
        return i;
    }

    @Override
    public List<User> findAllList() throws Exception {
        return userMapper.findAllList();
    }
}
