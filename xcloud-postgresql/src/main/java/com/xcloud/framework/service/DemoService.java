package com.xcloud.framework.service;

import com.xcloud.framework.entity.User;

import java.util.List;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/28 13:46
 **/
public interface DemoService {

    int save(User user) throws Exception;


    List<User> findAllList() throws Exception;
}
