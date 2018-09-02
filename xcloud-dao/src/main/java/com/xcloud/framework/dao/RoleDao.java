package com.xcloud.framework.dao;

import com.xcloud.framework.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色
 *
 * @Author administered
 * @Description
 * @Date 2018/9/2 16:28
 **/
@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
}
