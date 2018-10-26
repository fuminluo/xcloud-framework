package com.xcloud.framework.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xcloud.framework.dubbo.DubboService;

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
    @Override
    public String hello(String str) {
        return str;
    }
}
