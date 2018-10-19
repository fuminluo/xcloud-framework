package com.xcloud.framework.dubbo.controller;

import com.xcloud.framework.dubbo.service.DubboConsumerService;
import com.xcloud.framework.dubbo.service.DubboService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:44
 **/
@RestController
@Component
public class DemoController {

    @Autowired
    DubboConsumerService dubboConsumerService;

    @GetMapping("/hi/{str}")
    public String hello(@PathVariable(value = "str") String str){
        return dubboConsumerService.test(str);
    }
}
