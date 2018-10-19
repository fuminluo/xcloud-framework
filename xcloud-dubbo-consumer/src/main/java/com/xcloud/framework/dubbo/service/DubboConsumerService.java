package com.xcloud.framework.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 23:04
 **/
@Component
public class DubboConsumerService {

    @Reference
    DubboService dubboService;

    public String test(String str){
     return   dubboService.hello(str);
    }
}
