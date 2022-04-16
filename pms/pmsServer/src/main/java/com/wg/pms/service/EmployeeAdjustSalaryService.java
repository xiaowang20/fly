package com.wg.pms.service;

import com.wg.pms.entity.Adjustsalary;

import java.util.List;

/**
 * 员工调薪
 */
public interface EmployeeAdjustSalaryService {
    /**
     * 条件分页查询
     * @param page
     * @param size
     * @param eId
     * @return
     */
    List<Adjustsalary> list(Integer page, Integer size, Integer eId);

    /**
     * 添加调薪信息
     * @param adjustsalary
     * @return
     */
    int add(Adjustsalary adjustsalary);

    /**
     * 根据id修改调薪信息
     * @param adjustsalary
     * @return
     */
    int update(Adjustsalary adjustsalary);

    /**
     * 根据id删除调薪信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
