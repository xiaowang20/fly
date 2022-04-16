package com.wg.pms.service;

import com.wg.pms.entity.Employeeec;

import java.util.List;

/**
 * 员工奖罚Service
 */
public interface EmployeeEcService {
    /**
     * 条件分页查询
     * @param page
     * @param size
     * @param eId
     * @return
     */
    List<Employeeec> list(Integer page, Integer size, Integer eId);

    /**
     * 添加奖罚信息
     * @param employeeec
     * @return
     */
    int add(Employeeec employeeec);

    /**
     * 根据id修改奖罚信息
     * @param employeeec
     * @return
     */
    int update(Employeeec employeeec);

    /**
     * 根据id删除员工奖罚信息
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 通过员工名查询奖罚信息
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    List<Employeeec> list1(Integer page, Integer size, String keyword);
}
