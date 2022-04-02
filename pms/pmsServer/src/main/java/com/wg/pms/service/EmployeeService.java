package com.wg.pms.service;

import com.wg.pms.common.RespPageBean;
import com.wg.pms.entity.Employee;

import java.util.Date;
import java.util.List;

/**
 * 员工详情Service接口
 */
public interface EmployeeService {


    /**
     * 分页查询员工详情
     * @param page
     * @param size
     * @return
     */
    List<Employee> list(Integer page, Integer size,Employee employee);

    /**
     * 得到所有员工
     * @param page
     * @param size
     * @param keyword
     * @return
     */
    List<Employee> getEmp(Integer page, Integer size, String keyword);

    /**
     * 获取员工所有信息
     * @param page
     * @param size
     * @return
     */
    List<Employee> getAllEmp(int page, int size,String keyword);
}
