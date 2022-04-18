package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.dao.EmpRemoveDao;
import com.wg.pms.entity.Employeeec;
import com.wg.pms.entity.Employeeremove;
import com.wg.pms.entity.EmployeeremoveExample;
import com.wg.pms.mapper.EmployeeremoveMapper;
import com.wg.pms.service.EmployeeRemoveService;
import com.wg.pms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRemoveServiceImpl implements EmployeeRemoveService {
    @Autowired
    EmployeeremoveMapper employeeremoveMapper;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmpRemoveDao empRemoveDao;
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

    @Override
    public List<Employeeremove> list1(Integer page, Integer size, String keyword) {

        PageHelper.startPage(page,size);
        List<Employeeremove>  employeeremoves = new ArrayList<>();
        if (StringUtil.isNotEmpty(keyword)){
            List<Integer> idNyName1 = employeeService.getIdNyName1(keyword);
            for (Integer integer : idNyName1) {
                Employeeremove list3 = empRemoveDao.getList1(integer);
                if(list3!=null){
                    employeeremoves.add(list3);
                }

            }
            return employeeremoves;
        }

        List<Employeeremove> list2 = empRemoveDao.getList2(null);

        return list2;
    }
}
