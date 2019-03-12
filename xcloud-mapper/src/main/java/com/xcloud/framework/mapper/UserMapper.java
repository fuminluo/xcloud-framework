package com.xcloud.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcloud.framework.entity.User;

import java.util.List;

/**
 * 用户 映射器
 *
 * @author administered
 * @data 2018/8/31
 */


public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}
