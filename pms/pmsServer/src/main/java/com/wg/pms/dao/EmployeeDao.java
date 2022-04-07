package com.wg.pms.dao;

import com.wg.pms.entity.Employee;
import com.wg.pms.entity.vo.EmployeeQueryParams;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

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
    List<Employee> list(@Param("page") int page, @Param("size") int size,Employee queryParams);

    /**
     * 获取员工所有信息
     * @param page
     * @param size
     * @return
     */
    List<Employee> getAllEmp(@Param("page") int page,@Param("size") int size,@Param("keyword") String keyword);

    /**
     * 通过员工id获取所有信息
     * @param id
     * @return
     */
    Employee getByPrimaryKey(Integer id);

    /**
     * 根据所有员工信息列表添加
     * @param list
     * @return
     */
    Integer addEmps(@Param("list") List<Employee> list);
}
