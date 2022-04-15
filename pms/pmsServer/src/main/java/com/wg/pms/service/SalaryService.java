package com.wg.pms.service;

import com.wg.pms.entity.Salary;

import java.util.List;

/**
 * 薪资Service
 */
public interface SalaryService {
    /**
     * 分页查询薪资信息
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    List<Salary> list(Integer page, Integer size, String keyword);

    /**
     * 添加薪资信息
     * @param salary
     * @return
     */
    int add(Salary salary);

    /**
     * 根据id修改薪资信息
     * @param id
     * @param salary
     * @return
     */
    int update(Integer id, Salary salary);

    /**
     * 根据id删除薪资信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
