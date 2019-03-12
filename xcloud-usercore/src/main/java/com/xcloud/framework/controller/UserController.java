package com.xcloud.framework.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.common.request.*;
import com.xcloud.framework.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * 用户接口
 *
 * @author administered
 * @data 2018/8/31
 */
@Api(description = "用户管理API")
@RestController
public class UserController {


    @Autowired
    UserService userService;


    /**
     * @Description: 创建用户
     * @param: [createUser]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ApiOperation(value = "创建用户", notes = "创建用户")
    @PostMapping("/v1/user")
    public ResultInfo<?> createUser(@Valid @RequestBody CreateUserRequest createUser) throws Exception {
        if (userService.save(createUser)) {
            return ResultInfo.OK();
        } else {
            return ResultInfo.FALL();
        }
    }

    /**
     * @Description:获取用户列表
     * @param: [basePage]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ApiOperation(value = "获取用户列表", notes = "page：起始页，size：单页大小")
    @GetMapping("/v1/users")
    public ResultInfo<?> getUsers(@Valid @ModelAttribute BasePage basePage) {
        return ResultInfo.OK(userService.findList(basePage));
    }

    /**
     * @Description: 获取单用户信息
     * @param: [id：用户id]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ApiOperation(value = "获取单用户信息", notes = "id:用户id")
    @GetMapping("/v1/user/{id}")
    public ResultInfo<?> getOne(@PathVariable Long id) {
        return ResultInfo.OK(userService.findUserInfoById(id));
    }

    /**
     * @Description: 删掉单个用户
     * @param: [id：用户id]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ApiOperation(value = "获取单用户信息", notes = "id:用户id")
    @DeleteMapping("/v1/user/{id}")
    public ResultInfo<?> deleteOne(@PathVariable Long id) {
        Boolean bool = userService.deleteOne(id);
        if (bool) {
            return ResultInfo.OK();
        }
        return ResultInfo.FALL();
    }

    /**
     * @Description: 批量删除用户
     * @param: [deleteUsersRequest：用户id数组]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ApiOperation(value = "批量删除用户", notes = " userIds:用户id数组")
    @DeleteMapping("/v1/user/delete-batch")
    public ResultInfo<?> deleteBatchs(@Valid @RequestBody DeleteUsersRequest deleteUsersRequest) {
        Boolean bool = userService.deleteBatchs(deleteUsersRequest);
        if (bool) {
            return ResultInfo.OK();
        }
        return ResultInfo.FALL();
    }

    /**
     * @Description: 修改用户
     * @param: [request]
     * @returns: com.xcloud.framework.common.base.ResultInfo<?>
     * @author: administered
     * @date: 2019/3/12
     */
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping("/v1/user")
    public ResultInfo<?> updateOne(@Valid @RequestBody UpdateUserInfoRequest request) {
        Boolean bool = userService.updateOne(request);
        if (bool) {
            return ResultInfo.OK();
        }
        return ResultInfo.FALL();

    }
}
