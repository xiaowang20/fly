package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.wg.pms.entity.Employeeremove;
import com.wg.pms.entity.EmployeeremoveExample;
import com.wg.pms.mapper.EmployeeremoveMapper;
import com.wg.pms.service.EmployeeRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRemoveServiceImpl implements EmployeeRemoveService {
    @Autowired
    EmployeeremoveMapper employeeremoveMapper;
    @Override
    public List<Employeeremove> list(Integer page, Integer size, Integer eId) {

        PageHelper.startPage(page,size);
        EmployeeremoveExample employeeremoveExample = new EmployeeremoveExample();

        if (eId!=null){
            employeeremoveExample.createCriteria().andEidEqualTo(eId);
        }
        return employeeremoveMapper.selectByExample(employeeremoveExample);
    }

    @Override
    public int add(Employeeremove employeeremove) {

        return employeeremoveMapper.insert(employeeremove);
    }

    @Override
    public int update(Employeeremove employeeremove) {

        return employeeremoveMapper.updateByPrimaryKeySelective(employeeremove);
    }

    @Override
    public int delete(Integer id) {

        return employeeremoveMapper.deleteByPrimaryKey(id);
    }
}
