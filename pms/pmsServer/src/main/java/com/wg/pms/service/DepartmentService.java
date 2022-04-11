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
}
