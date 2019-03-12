package com.xcloud.framework.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.common.request.CreateRoleRequest;
import com.xcloud.framework.common.request.IdRequest;
import com.xcloud.framework.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色管理控制层
 *
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:38
 **/
@Api(description = "角色管理API")
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;


    @ApiOperation(value = "创建角色", notes = "创建角色")
    @PostMapping("/v1/role")
    public ResultInfo<?> createUser(@Valid @RequestBody CreateRoleRequest createRole) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, roleService.save(createRole));
    }


    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    @GetMapping("/v1/roles")
    public ResultInfo<?> getUsers(@Valid @ModelAttribute BasePage basePage) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS);
    }

    @ApiOperation(value = "获取单用户", notes = "获取单用户")
    @GetMapping("/v1/role/{id}")
    public ResultInfo<?> getUser(@PathVariable Long id) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, "User");
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping("/v1/role")
    public ResultInfo<?> updateUser(@Valid @ModelAttribute IdRequest request) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, request.getId());
    }
}
