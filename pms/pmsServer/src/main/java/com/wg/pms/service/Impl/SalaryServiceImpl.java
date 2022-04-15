package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.entity.Salary;
import com.wg.pms.entity.SalaryExample;
import com.wg.pms.mapper.SalaryMapper;
import com.wg.pms.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryMapper salaryMapper;
    @Override
    public List<Salary> list(Integer page, Integer size, String keyword) {

        PageHelper.startPage(page,size);
        SalaryExample salaryExample = new SalaryExample();
        if (StringUtil.isNotEmpty(keyword)){
            salaryExample.createCriteria().andNameLike("%"+keyword+"%");
        }
        List<Salary> salaries = salaryMapper.selectByExample(salaryExample);
        return salaries;
    }

    @Override
    public int add(Salary salary) {

        salary.setCreatedate(new Date());
        return salaryMapper.insert(salary);
    }

    @Override
    public int update(Integer id, Salary salary) {

        salary.setId(id);
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    @Override
    public int delete(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }
}
