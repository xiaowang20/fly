package com.wg.pms.service.Impl;

import com.wg.pms.entity.Department;
import com.wg.pms.mapper.DepartmentMapper;
import com.wg.pms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    //根据父id拿到所有部门
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);

    }
}
