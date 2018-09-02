package com.xcloud.framework.dao;

import com.xcloud.framework.common.response.UserInfoResponse;
import com.xcloud.framework.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user 持久层
 *
 * @Author administered
 * @Description
 * @Date 2018/9/2 15:53
 **/
@Repository
public interface UserDao extends CrudRepository<User, Long> {


    @Query(value = "SELECT u.id,u.username,u.nickname,u.phone,u.photo , (SELECT r.name FROM t_role r WHERE r.id =(SELECT ru.role_id FROM t_role_user ru WHERE ru.user_id = u.id)) AS roleName FROM t_user u  WHERE id = ?1 ", nativeQuery = true)
    List<Object[]> findUserInfo(@Param("id") Long id);


}
