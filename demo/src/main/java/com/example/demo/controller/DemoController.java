package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author administered
 * @Description
 * @Date 2018/12/1 21:31
 **/
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(String name) {

        return "hi" + name;
    }
}
