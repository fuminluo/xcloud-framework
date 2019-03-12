package com.xcloud.framework.common.request;

import java.io.Serializable;
import java.util.Set;

/**
 * @Description: 批量删除用户
 * @author: administered
 * @date: 2019/3/12
 */
public class DeleteUsersRequest implements Serializable {

    private static final long serialVersionUID = 7440437436825565578L;

    private Set<IdRequest> userIds;

    public Set<IdRequest> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<IdRequest> userIds) {
        this.userIds = userIds;
    }
}
