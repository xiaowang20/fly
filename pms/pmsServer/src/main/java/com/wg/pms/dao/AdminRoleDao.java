package com.wg.pms.dao;

import com.wg.pms.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色关系管理自定义Dao
 */
public interface AdminRoleDao {
    /**
     * 获取用于所有角色
     */
    List<Role> getRoleList(@Param("adminId") Long adminId);
}
