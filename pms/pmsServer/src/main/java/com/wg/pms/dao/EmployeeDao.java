package com.wg.pms.dao;

import com.wg.pms.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 员工详情dao
 */
public interface EmployeeDao {
    /**
     * 分页查询员工详情
     * @param page
     * @param size
     * @return
     */
    List<Employee> list(@Param("page") Integer page, @Param("size") Integer size,@Param("emp") Employee employee);

    /**
     * 获取员工所有信息
     * @param page
     * @param size
     * @return
     */
    List<Employee> getAllEmp(@Param("page") int page,@Param("size") int size,@Param("keyword") String keyword);

}
