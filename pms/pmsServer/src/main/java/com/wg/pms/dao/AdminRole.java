package com.wg.pms.dao;


import com.wg.pms.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminRole {

    /**
     * 获取资源
     * @param adminId
     * @return
     */
    List<Menu> getAllMenus(@Param("adminId") long adminId);
}
