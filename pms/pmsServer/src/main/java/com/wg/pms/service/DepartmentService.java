package com.wg.pms.service;

import com.wg.pms.entity.Department;

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

}
