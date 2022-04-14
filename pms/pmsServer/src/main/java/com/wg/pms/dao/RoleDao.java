package com.wg.pms.dao;

import com.wg.pms.entity.Menu;
import com.wg.pms.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台角色管理dao
 */
public interface RoleDao {
    /**
     * 根据后台用户ID获取菜单
     */
    List<Menu> getMenuList(@Param("adminId") Long adminId);

    /**
     * 通过adminId获取角色list
     * @param adminId
     * @return
     */
    List<Role> getRoleList(@Param("adminId") Long adminId);
}
