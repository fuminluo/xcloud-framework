package com.xcloud.framework.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.common.request.DeleteUsersRequest;
import com.xcloud.framework.common.request.UpdateUserInfoRequest;
import com.xcloud.framework.common.response.UserInfoResponse;
import com.xcloud.framework.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @Author administered
 * @Description ：用户业务逻辑接口
 * @Date 2018/9/2 17:14
 **/
public interface UserService {

    /**
     * @Description: 创建用户
     * @param: [createUser]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    Boolean save(CreateUserRequest createUser) throws Exception;

    /**
     * @Description: 获取单用户信息
     * @param: [id：用户id]
     * @returns: com.xcloud.framework.entity.User
     * @author: administered
     * @date: 2019/3/12
     */
    User findUserInfoById(Long id);

    /**
     * @Description: 查询用户列表
     * @param: [basePage]
     * @returns: com.baomidou.mybatisplus.core.metadata.IPage<com.xcloud.framework.entity.User>
     * @author: administered
     * @date: 2019/3/12
     */
    IPage<User> findList(BasePage basePage);

    /**
     * @Description: 删除用户id
     * @param: [id：用户id]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    Boolean deleteOne(Long id);

    /**
     * @Description: 修改用户信息
     * @param: [request]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    Boolean updateOne(UpdateUserInfoRequest request);


    /**
     * @Description: 批量删除用户
     * @param: [deleteUsersRequest]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    Boolean deleteBatchs(DeleteUsersRequest deleteUsersRequest);
}
