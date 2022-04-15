package com.wg.pms.service;

import com.wg.pms.entity.Department;
import com.wg.pms.entity.DepartmentExample;

import java.util.List;

/**
 * 部门Service
 */
public interface DepartmentService {
    /**
     * 获取所有部门信息
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 树形结构返回所有部门信息
     * @return
     */
    List<Department> getAllList();
    /**
     * 获取所有数据
     *
     */
    List<Department> selectAll(DepartmentExample departmentExample);

    /**
     * 添加部门
     * @param department
     * @return
     */
    int add(Department department);

    /**
     * 根据id修改部门信息
     * @param id
     * @param department
     * @return
     */
    int update(Integer id, Department department);

    /**
     * 根据id删除部门信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
