package com.wg.pms.service;



import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Menu;
import com.wg.pms.entity.Role;

import java.util.List;

public interface HrService {
    /**
     * 根据用户名获取后台管理员
     */
    Hr getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<Menu> getPermissionList(long adminId);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 注册
     * @param adminParam
     * @return
     */
    Hr register(Hr adminParam);

    /**
     * 条件分页查询全部admin
     * @return
     */
    List<Hr> list(Integer  page,Integer size,String keyword);

    /**
     * 修改用户状态
     * @param id
     * @param hr
     * @return
     */
    int updateStatus(Long id, Hr hr);


    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据adminId获取角色信息
     * @param adminId
     * @return
     */
    List<Role> getRoleList(Long adminId);

    /**
     * 分配角色
     * @param adminId
     * @param roleIds
     * @return
     */
    int updateRole(Integer adminId, List<Integer> roleIds);
}
