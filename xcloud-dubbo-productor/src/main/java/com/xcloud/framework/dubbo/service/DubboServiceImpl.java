package com.xcloud.framework.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xcloud.framework.dubbo.DubboService;
import com.xcloud.framework.dubbo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:29
 **/
@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DubboServiceImpl implements DubboService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String hello(String str) {
        return str;
    }

    @Override
    public List findAllList() {
        System.out.println(userMapper);
        return userMapper.findAllList();
    }
}
