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
     * 获取员工所有信息
     * @param page
     * @param size
     * @return
     */
    List<Employee> getAllEmp(int page, int size,String keyword);

    /**
     * 根据id删除员工
     * @param id
     * @return
     */
    int delete(Integer id);
}
