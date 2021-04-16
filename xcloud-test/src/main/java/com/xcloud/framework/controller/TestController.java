package com.xcloud.framework.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.demo.starter.XxTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xxx.starter.TestTemplate;

import javax.validation.Valid;
import java.util.UUID;

/**
 * 案例口层
 *
 * @author administered
 * @data 2018/8/31
 */
@RestController
public class TestController {

    @Autowired
    XxTemplate xxTemplate;

    @Autowired
    TestTemplate testTemplate;


    @GetMapping("/v1/test")
    public ResultInfo<?> getUsers(@Valid @ModelAttribute BasePage basePage) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, xxTemplate.get(UUID.randomUUID().toString()));
    }

    @GetMapping("/v1/test2")
    public ResultInfo<?> testTemplate(@Valid @ModelAttribute BasePage basePage) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, testTemplate.get(UUID.randomUUID().toString()));
    }

    @GetMapping("/v1/test/{id}")
    public ResultInfo<?> getUser(@PathVariable Long id) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, "Tset");
    }
}
