package com.wg.pms.dao;

import com.wg.pms.entity.Menu;
import com.wg.pms.entity.dto.MenuNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单dao
 */
public interface MenuDao {
    List<MenuNode> getAllMenuWithOutChildren();

    /**
     * mybatis构造树形结构
     * @return
     */
    List<MenuNode> getAllMenus();

    /**
     * 通过roleId获取菜单信息
     * @return
     */
    List<MenuNode> getAllMenusByRoleId(@Param("roleId") Integer roleId);
}
