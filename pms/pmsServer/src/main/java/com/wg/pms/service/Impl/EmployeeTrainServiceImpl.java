package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.wg.pms.entity.Employeetrain;
import com.wg.pms.entity.EmployeetrainExample;
import com.wg.pms.mapper.EmployeetrainMapper;
import com.wg.pms.service.EmployeeTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTrainServiceImpl implements EmployeeTrainService {
    @Autowired
    EmployeetrainMapper employeetrainMapper;
    @Override
    public List<Employeetrain> list(Integer page, Integer size, Integer eId) {

        PageHelper.startPage(page,size);
        EmployeetrainExample employeetrainExample = new EmployeetrainExample();
        if (eId!=null){
            employeetrainExample.createCriteria().andEidEqualTo(eId);
        }
        return employeetrainMapper.selectByExample(employeetrainExample);
    }

    @Override
    public int add(Employeetrain employeetrain) {

        return employeetrainMapper.insert(employeetrain);
    }

    @Override
    public int update(Employeetrain employeetrain) {

        return employeetrainMapper.updateByPrimaryKeySelective(employeetrain);
    }

    @Override
    public int delete(Integer id) {

        return employeetrainMapper.deleteByPrimaryKey(id);
    }
}
