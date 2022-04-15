package com.wg.pms.service.Impl;

import com.wg.pms.entity.Department;
import com.wg.pms.entity.DepartmentExample;
import com.wg.pms.mapper.DepartmentMapper;
import com.wg.pms.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    //根据父id拿到所有部门
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(0);

    }

    @Override
    public List<Department> getAllList() {
        List<Department> departmentListParent = departmentMapper.selectByExample(new DepartmentExample());
        List<Department> result = departmentListParent.stream()
                .filter(department -> department.getParentid().equals(0))
                .map(department -> covertMenuNode(department, departmentListParent)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Department> selectAll(DepartmentExample departmentExample) {

        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public int add(Department department) {

        return departmentMapper.insert(department);
    }

    @Override
    public int update(Integer id, Department department) {

        department.setId(id);
        int i = departmentMapper.updateByPrimaryKeySelective(department);
        return i;
    }

    @Override
    public int delete(Integer id) {

        return departmentMapper.deleteByPrimaryKey(id);
    }

    private Department covertMenuNode(Department department, List<Department> departmentListParent) {
        Department node = new Department();
        BeanUtils.copyProperties(department, node);
        List<Department> children = departmentListParent.stream()
                .filter(subMenu -> subMenu.getParentid().equals(department.getId()))
                .map(subMenu -> covertMenuNode(subMenu, departmentListParent)).collect(Collectors.toList());

        node.setChildren(children);
        return node;
    }
}
