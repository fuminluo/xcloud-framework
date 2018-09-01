package com.xcloud.framework.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户接口
 * @author LuoFuMin
 * @data 2018/8/31
 */
@RestController
public class UserController {

    @Autowired
    DemoService demoService;

    @PostMapping("/v1/user/")
    public ResultInfo<?> createUser(@Valid @RequestBody CreateUserRequest createUser) throws Exception {

        demoService.save(createUser);

        return new ResultInfo<>(ResultInfo.SUCCESS, "User");
    }

    @GetMapping("/v1/user/")
    public ResultInfo<?> getUsers(@Valid @ModelAttribute BasePage basePage) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, "User");
    }

    @GetMapping("/v1/user/{id}")
    public ResultInfo<?> getUser(@PathVariable Long id) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, "User");
    }
}
