package com.wg.pms.dao;

import com.wg.pms.entity.HrRole;
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

    /**
     * 插入adminId和roleIds的list
     * @param list
     * @return
     */
    int insertList(@Param("list") List<HrRole> list);
}
