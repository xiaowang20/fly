package com.wg.pms.service;



import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Menu;

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
}
