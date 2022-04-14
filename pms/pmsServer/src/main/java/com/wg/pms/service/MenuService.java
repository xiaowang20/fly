package com.wg.pms.service;

import com.wg.pms.entity.Menu;

import java.util.List;

/**
 * 菜单Service
 */
public interface MenuService {
    /**
     * 条件分页查询菜单
     * @param parentId
     * @param page
     * @param size
     * @return
     */
    List<Menu> list(Integer parentId, Integer page, Integer size);

    /**
     * 修改菜单状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Integer id, Boolean status);

    /**
     * 修改菜单keepAlive
     * @param id
     * @param keepAlive
     * @return
     */
    int updateKeepAlive(Integer id, Boolean keepAlive);

    /**
     * 修改菜单requireAuth
     * @param id
     * @param requireAuth
     * @return
     */
    int updateRequireAuth(Integer id, Boolean requireAuth);

    /**
     * 添加成功
     * @param menu
     * @return
     */
    int add(Menu menu);

    /**
     * 根据id修改菜单
     * @param id
     * @param menu
     * @return
     */
    int update(Integer id, Menu menu);

    /**
     * 根据id获取指定菜单
     * @param id
     * @return
     */
    Menu getMenuById(Integer id);
}
