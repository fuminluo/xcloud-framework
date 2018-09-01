package com.xcloud.framework.mapper;

import com.xcloud.framework.entity.User;

import java.util.List;

/**
 * 用户 映射器
 *
 * @author LuoFuMin
 * @data 2018/8/31
 */

public interface UserMapper{

    List<User> findAll();
}
