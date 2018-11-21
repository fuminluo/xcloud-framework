package com.xcloud.framework.pgsql.service.impl;

import com.xcloud.framework.pgsql.entity.User;
import com.xcloud.framework.pgsql.mapper.PgsqlUserMapper;
import com.xcloud.framework.pgsql.service.DemoService;
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
    PgsqlUserMapper pgsqlUserMapper;

    @Override
    @Transactional
    public int save(User user) throws Exception {
        int i = pgsqlUserMapper.insertSelective(user);
        return i;
    }

    @Override
    public List<User> findAllList() throws Exception {
        return pgsqlUserMapper.findAllList();
    }
}
