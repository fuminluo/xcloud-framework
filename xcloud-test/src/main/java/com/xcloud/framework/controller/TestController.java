package com.xcloud.framework.controller;

import com.xcloud.framework.common.base.ResultInfo;
import com.xcloud.framework.common.request.BasePage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 案例口层
 *
 * @author LuoFuMin
 * @data 2018/8/31
 */
@RestController
public class TestController {


    @GetMapping("/v1/tests")
    public ResultInfo<?> getUsers(@Valid @ModelAttribute BasePage basePage) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, "Tset");
    }

    @GetMapping("/v1/test/{id}")
    public ResultInfo<?> getUser(@PathVariable Long id) throws Exception {
        return new ResultInfo<>(ResultInfo.SUCCESS, "Tset");
    }
}
