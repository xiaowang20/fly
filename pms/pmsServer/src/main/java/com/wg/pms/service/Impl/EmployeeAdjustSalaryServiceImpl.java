package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.dao.AdjustSalaryDao;
import com.wg.pms.entity.Adjustsalary;
import com.wg.pms.entity.AdjustsalaryExample;
import com.wg.pms.entity.Employeeremove;
import com.wg.pms.mapper.AdjustsalaryMapper;
import com.wg.pms.service.EmployeeAdjustSalaryService;
import com.wg.pms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeAdjustSalaryServiceImpl implements EmployeeAdjustSalaryService {
    @Autowired
    AdjustsalaryMapper adjustsalaryMapper;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AdjustSalaryDao adjustSalaryDao;
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

    @Override
    public List<Adjustsalary> list1(Integer page, Integer size, String keyword) {
        PageHelper.startPage(page,size);
        List<Adjustsalary>  employeeremoves = new ArrayList<>();
        if (StringUtil.isNotEmpty(keyword)){
            List<Integer> idNyName1 = employeeService.getIdNyName1(keyword);
            for (Integer integer : idNyName1) {
                Adjustsalary list3 = adjustSalaryDao.getList1(integer);
                if(list3!=null){
                    employeeremoves.add(list3);
                }

            }
            return employeeremoves;
        }

        List<Adjustsalary> list2 = adjustSalaryDao.getList2(null);

        return list2;

    }
}
