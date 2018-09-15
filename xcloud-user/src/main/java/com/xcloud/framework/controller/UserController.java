package com.xcloud.framework.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.common.request.IdRequest;
import com.xcloud.framework.mapper.UserMapper;
import com.xcloud.framework.service.DemoService;
import com.xcloud.framework.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户接口
 *
 * @author LuoFuMin
 * @data 2018/8/31
 */
@Api(description = "用户管理API")
@RestController
public class UserController {

    @Autowired
    DemoService demoService;

    @Autowired
    UserService userService;



    @Autowired
    UserMapper userMapper;

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @PostMapping("/v1/user")
    public ResultInfo<?> createUser(@Valid @RequestBody CreateUserRequest createUser) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, userService.save(createUser));
    }


    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/v1/users")
    public ResultInfo<?> getUsers(@Valid @ModelAttribute BasePage basePage) throws Exception {
        userMapper.findAll();
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS,userMapper.selectList(null));
    }

    @ApiOperation(value = "获取单用户", notes = "获取单用户")
    @GetMapping("/v1/user/{id}")
    public ResultInfo<?> getUser(@PathVariable Long id) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, userService.findUserInfoById(id));
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping("/v1/user")
    public ResultInfo<?> updateUser(@Valid @ModelAttribute IdRequest request) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, request.getId());
    }
}
