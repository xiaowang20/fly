package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.dao.EcDao;
import com.wg.pms.entity.Employeeec;
import com.wg.pms.entity.EmployeeecExample;
import com.wg.pms.mapper.EmployeeecMapper;
import com.wg.pms.service.EmployeeEcService;
import com.wg.pms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEcServiceImpl implements EmployeeEcService {
    @Autowired
    EmployeeecMapper employeeecMapper;
    @Autowired
    EcDao ecDao;
    @Autowired
    EmployeeService employeeService;
    @Override
    public List<Employeeec> list(Integer page, Integer size, Integer eId) {

        PageHelper.startPage(page,size);
        EmployeeecExample employeeecExample = new EmployeeecExample();
        if (eId!=null){
            employeeecExample.createCriteria().andEidEqualTo(eId);
        }
        return employeeecMapper.selectByExample(employeeecExample);
    }

    @Override
    public int add(Employeeec employeeec) {

        return employeeecMapper.insert(employeeec);
    }

    @Override
    public int update(Employeeec employeeec) {

        return employeeecMapper.updateByPrimaryKeySelective(employeeec);
    }

    @Override
    public int delete(Integer id) {

        return employeeecMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Employeeec> list1(Integer page, Integer size, String keyword) {
        PageHelper.startPage(page,size);
        Integer idByName=null;
        if (StringUtil.isNotEmpty(keyword)){
             idByName = employeeService.getIdByName(keyword);
        }


        return ecDao.getList(idByName);
    }
}
