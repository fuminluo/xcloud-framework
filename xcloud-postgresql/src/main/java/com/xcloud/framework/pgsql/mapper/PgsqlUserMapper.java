package com.xcloud.framework.pgsql.mapper;

import com.xcloud.framework.pgsql.entity.User;

import java.util.List;

public interface PgsqlUserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> findAllList();
}