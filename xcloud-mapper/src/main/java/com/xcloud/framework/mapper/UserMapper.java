package com.xcloud.framework.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xcloud.framework.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户 映射器
 *
 * @author LuoFuMin
 * @data 2018/8/31
 */


public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}
