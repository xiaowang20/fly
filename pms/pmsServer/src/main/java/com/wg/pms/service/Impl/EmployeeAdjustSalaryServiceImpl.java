package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.wg.pms.entity.Adjustsalary;
import com.wg.pms.entity.AdjustsalaryExample;
import com.wg.pms.mapper.AdjustsalaryMapper;
import com.wg.pms.service.EmployeeAdjustSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAdjustSalaryServiceImpl implements EmployeeAdjustSalaryService {
    @Autowired
    AdjustsalaryMapper adjustsalaryMapper;
    @Override
    public List<Adjustsalary> list(Integer page, Integer size, Integer eId) {

        PageHelper.startPage(page,size);
        AdjustsalaryExample adjustsalaryExample = new AdjustsalaryExample();
        if (eId!=null){
            adjustsalaryExample.createCriteria().andEidEqualTo(eId);
        }
        return adjustsalaryMapper.selectByExample(adjustsalaryExample);
    }

    @Override
    public int add(Adjustsalary adjustsalary) {

        return adjustsalaryMapper.insert(adjustsalary);
    }

    @Override
    public int update(Adjustsalary adjustsalary) {

        return adjustsalaryMapper.updateByPrimaryKeySelective(adjustsalary);
    }

    @Override
    public int delete(Integer id) {

        return adjustsalaryMapper.deleteByPrimaryKey(id);
    }
}
