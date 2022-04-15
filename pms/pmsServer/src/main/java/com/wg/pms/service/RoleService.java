package com.wg.pms.service;

import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Menu;
import com.wg.pms.entity.Role;
import com.wg.pms.entity.dto.MenuNode;

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

    /**
     * 条件分页查询role
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    List<Role> list(Integer page, Integer size, String keyword);

    /**
     * 获取所有角色信息
     * @return
     */
    List<Role> listAll();

    /**
     * 添加角色
     * @return
     */
    int add( Role role);

    /**
     * 根据RoleId更新角色
     * @param id
     * @param role
     * @return
     */
    int update(Integer id, Role role);

    /**
     *
     * @param roleIds
     * @return
     */
    int delete(List<Integer> roleIds);

    /**
     * 给角色分配菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    int allocMenu(Integer roleId, List<Integer> menuIds);

    /**
     * 根据roleId获取菜单信息
     * @param roleId
     * @return
     */
    List<MenuNode> getMenuByRoleId(Integer roleId);
}
