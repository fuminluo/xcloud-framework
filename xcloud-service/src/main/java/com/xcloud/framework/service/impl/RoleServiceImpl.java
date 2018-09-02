package com.xcloud.framework.service.impl;

import com.xcloud.framework.common.request.CreateRoleRequest;
import com.xcloud.framework.dao.RoleDao;
import com.xcloud.framework.entity.Role;
import com.xcloud.framework.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 角色管理 业务逻辑实现
 *
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:39
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public Role save(CreateRoleRequest createRole) {
        Role role = new Role();
        role.setCode(createRole.getCode());
        role.setName(createRole.getName());
        role.setDepict(createRole.getDepict());
        return roleDao.save(role);
    }
}
