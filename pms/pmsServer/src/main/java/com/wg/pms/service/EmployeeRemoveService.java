package com.wg.pms.service;

import com.wg.pms.entity.Employeeec;
import com.wg.pms.entity.Employeeremove;

import java.util.List;

/**
 * 员工调动
 */
public interface EmployeeRemoveService {
    /**
     * 查询员工调动信息
     * @param page
     * @param size
     * @param eId
     * @return
     */
    List<Employeeremove> list(Integer page, Integer size, Integer eId);

    /**
     * 添加员工调动信息
     * @param employeeremove
     * @return
     */
    int add(Employeeremove employeeremove);

    /**
     * 根据id修改员工调动信息
     * @param employeeremove
     * @return
     */
    int update(Employeeremove employeeremove);

    /**
     * 根据id删除员工调动信息
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 搜索
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    List<Employeeremove> list1(Integer page, Integer size, String keyword);
}
