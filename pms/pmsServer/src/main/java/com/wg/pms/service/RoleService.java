package com.wg.pms.service;

import com.wg.pms.entity.Menu;
import com.wg.pms.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 根据用户id获取菜单信息
     * @param adminId
     * @return
     */
    List<Menu> getMenuList(Long adminId);
    /**
     * 获取用户对应角色
     */
    List<Role> getRoleList(Long adminId);
}
