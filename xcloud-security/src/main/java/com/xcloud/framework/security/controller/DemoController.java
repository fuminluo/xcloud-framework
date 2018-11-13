package com.xcloud.framework.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/28 20:02
 **/
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
