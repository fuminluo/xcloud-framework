package com.xcloud.framework.dubbo.mapper;

import com.xcloud.framework.dubbo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> findAllList();
}