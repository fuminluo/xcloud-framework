package com.xcloud.framework.service;

import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service demo
 *
 * @Author administered
 * @Description
 * @Date 2018/9/1 14:56
 **/
public interface DemoService {

 User save(CreateUserRequest createUser);

 List<User> findList();
}
