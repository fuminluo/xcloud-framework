package com.xcloud.framework.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xcloud.framework.dubbo.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:44
 **/
@RestController
public class DemoController {


    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    DubboService dubboService;

    @GetMapping("/hi/{str}")
    public String hello(@PathVariable(value = "str") String str) {
        return dubboService.hello(str);
    }

    @GetMapping("/users")
    public Object getUsers() {
        return dubboService.findAllList();
    }
}
