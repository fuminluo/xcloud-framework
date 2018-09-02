package com.xcloud.framework.service;

import com.xcloud.framework.common.request.CreateRoleRequest;
import com.xcloud.framework.entity.Role;

/**
 * 角色管理 业务逻辑 接口
 *
 * @Author administered
 * @Description
 * @Date 2018/9/2 17:39
 **/
public interface RoleService {

    Role save(CreateRoleRequest createRole);
}
