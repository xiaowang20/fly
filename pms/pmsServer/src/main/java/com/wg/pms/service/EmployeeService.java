package com.wg.pms.service;

import com.wg.pms.common.RespPageBean;
import com.wg.pms.entity.Employee;
import com.wg.pms.entity.vo.EmployeeQueryParams;

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
    List<Employee> list(int page, int size, EmployeeQueryParams queryParams);


    /**
     * 获取员工所有信息
     * @param page
     * @param size
     * @return
     */
    List<Employee> getAllEmp(Integer page, Integer size,String keyword);

    /**
     * 根据id删除员工
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    int add(Employee employee);

    /**
     * 更新员工
     * @param employee
     * @return
     */
    int update(Employee employee);

    /**
     * 根据所有的员工信息列表添加
     * @param employeeList
     * @return
     */
    Integer addEmps(List<Employee> employeeList);
}
