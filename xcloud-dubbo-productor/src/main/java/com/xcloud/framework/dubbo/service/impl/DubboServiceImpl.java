package com.xcloud.framework.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xcloud.framework.dubbo.service.DubboService;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:29
 **/
@Service
public class DubboServiceImpl implements DubboService{
    @Override
    public String hello(String str) {
        return str;
    }
}
