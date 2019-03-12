package com.xcloud.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcloud.framework.common.exception.XcloudBaseException;
import com.xcloud.framework.common.request.BasePage;
import com.xcloud.framework.common.request.CreateUserRequest;
import com.xcloud.framework.common.request.DeleteUsersRequest;
import com.xcloud.framework.common.request.UpdateUserInfoRequest;
import com.xcloud.framework.entity.User;
import com.xcloud.framework.mapper.UserMapper;
import com.xcloud.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


/**
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:14
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    /**
     * @Description: 创建用户
     * @param: [createUser]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    @Override
    @Transactional
    public Boolean save(CreateUserRequest createUser) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", createUser.getUsername());
        Integer i = userMapper.selectCount(queryWrapper);
        if (i > 0) {
            throw new XcloudBaseException(400, "用户名已经存在");
        }
        User user = new User();
        user.setUsername(createUser.getUsername());
        user.setPassword(createUser.getPassword());
        return userMapper.insert(user) > 0;
    }

    /**
     * @Description: 获取单用户信息
     * @param: [id：用户id]
     * @returns: com.xcloud.framework.entity.User
     * @author: administered
     * @date: 2019/3/12
     */
    @Override
    public User findUserInfoById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     * @Description: 查询用户列表
     * @param: [basePage]
     * @returns: com.baomidou.mybatisplus.core.metadata.IPage<com.xcloud.framework.entity.User>
     * @author: administered
     * @date: 2019/3/12
     */
    @Override
    public IPage<User> findList(BasePage basePage) {
        Page<User> page = new Page<>(basePage.getPage(), basePage.getSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);
        return userIPage;
    }

    /**
     * @Description: 删除用户id
     * @param: [id：用户id]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    @Override
    @Transactional
    public Boolean deleteOne(Long id) {
        return userMapper.deleteById(id) > 0;
    }

    /**
     * @Description: 修改用户信息
     * @param: [request]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    @Override
    @Transactional
    public Boolean updateOne(UpdateUserInfoRequest request) {

        User user = new User(request.getId());
        if (StringUtils.isEmpty(request.getSex())) {
            user.setSex(request.getSex());
        }
        if (StringUtils.isEmpty(request.getAddress())) {
            user.setAddress(request.getAddress());
        }
        if (StringUtils.isEmpty(request.getNickname())) {
            user.setNickname(request.getNickname());
        }
        if (StringUtils.isEmpty(request.getEmail())) {
            user.setEmail(request.getEmail());
        }
        if (StringUtils.isEmpty(request.getPhone())) {
            user.setPhone(request.getPhone());
        }
        if (request.getBirthday() != null) {
            user.setBirthday(request.getBirthday());
        }
        if (StringUtils.isEmpty(request.getPhoto())) {
            user.setPhoto(request.getPhoto());
        }
        return userMapper.updateById(user) > 0;
    }

    /**
     * @Description: 批量删除用户
     * @param: [deleteUsersRequest]
     * @returns: java.lang.Boolean
     * @author: administered
     * @date: 2019/3/12
     */
    @Override
    @Transactional
    public Boolean deleteBatchs(DeleteUsersRequest deleteUsersRequest) {
        int deleteCount = userMapper.deleteBatchIds(deleteUsersRequest.getUserIds());
        if (deleteCount != deleteUsersRequest.getUserIds().size()) {
            throw new XcloudBaseException(400, "数据有误");
        }
        return true;
    }
}
