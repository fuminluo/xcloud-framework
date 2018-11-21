package com.xcloud.framework.pgsql.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.pgsql.entity.User;
import com.xcloud.framework.pgsql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author administered
 * @Description
 * @Date 2018/10/27 21:36
 **/
@RestController
public class PostgreSQLController {

    @Autowired
    DemoService demoService;

    /**
     * @描述 保存用户
     * @参数 user
     * @返回值 Object
     * @创建人 admin
     * @创建时间 2018/10/28
     */
    @PostMapping("/save")
    public ResultInfo<?> save(@RequestBody User user) throws Exception {
        int i = demoService.save(user);
        if (i > 0) {
            return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS);
        }
        return new ResultInfo<>(ResultInfo.FAIL, ResultInfo.MSG_FAIL);
    }

    /**
     * @描述 查询用户列表
     * @参数 无
     * @返回值 List<User>
     * @创建人 admin
     * @创建时间 2018/10/28
     */
    @GetMapping("/users")
    public ResultInfo<?> users() throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, demoService.findAllList());
    }
}
