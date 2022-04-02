package com.wg.pms.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.common.RespPageBean;
import com.wg.pms.dao.EmployeeDao;
import com.wg.pms.entity.*;
import com.wg.pms.mapper.EmployeeMapper;
import com.wg.pms.mapper.NationMapper;
import com.wg.pms.service.EmployeeService;
import com.wg.pms.service.PoliticsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    PoliticsStatusService politicsStatusService;
    @Autowired
    NationMapper nationMapper;
    @Override
    public List<Employee> list(Integer page, Integer size,Employee employee) {

        return employeeDao.list(page, size,employee);

    }

    @Override
    public List<Employee> getEmp(Integer page, Integer size, String keyword) {
        PageHelper.startPage(page,size);
        EmployeeExample example = new EmployeeExample();
//        example.setOrderByClause("id desc");
        if (!StringUtil.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return employeeMapper.selectByExample(example);
    }

    @Override
    public List<Employee> getAllEmp(int page, int size,String keyword) {
//        PageHelper.startPage(page,size);
        List<Employee> allEmp = employeeDao.getAllEmp(page, size, keyword);
        System.out.println(allEmp);
        return allEmp;
    }



}
