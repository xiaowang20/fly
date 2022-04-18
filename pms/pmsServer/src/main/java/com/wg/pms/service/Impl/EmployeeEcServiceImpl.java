package com.wg.pms.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.dao.EcDao;
import com.wg.pms.entity.Employee;
import com.wg.pms.entity.Employeeec;
import com.wg.pms.entity.EmployeeecExample;
import com.wg.pms.mapper.EmployeeecMapper;
import com.wg.pms.service.EmployeeEcService;
import com.wg.pms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


//        Integer idByName = employeeService.getIdByName(keyword);
//        System.out.println(idByName);
//        List<Employeeec> list = ecDao.getList(idByName);
        if (StringUtil.isNotEmpty(keyword)){
            List<Integer> idNyName1 = employeeService.getIdNyName1(keyword);
            for (Integer integer : idNyName1) {
                List<Employeeec> list = ecDao.getList(integer);
                return list;
            }
        }
        return ecDao.getList(null);

    }

    @Override
    public List<Employeeec> list2(Integer page, Integer size, String keyword) {

        PageHelper.startPage(page,size);
        List<Employeeec>  employeeecs = new ArrayList<>();
        if (StringUtil.isNotEmpty(keyword)){
            List<Integer> idNyName1 = employeeService.getIdNyName1(keyword);
            for (Integer integer : idNyName1) {

                Employeeec list3 = ecDao.getList1(integer);
                if(list3!=null){
                    employeeecs.add(list3);
                }

            }
            return employeeecs;
        }

        List<Employeeec> list3 = ecDao.getList3(null);

        return list3;
    }

    @Override
    public List<List<Employeeec>> list3(Integer page, Integer size, String keyword) {
        PageHelper.startPage(page,size);
        List< List<Employeeec>> employeeecs = new ArrayList<>();
        if (StringUtil.isNotEmpty(keyword)){
            List<Integer> idNyName1 = employeeService.getIdNyName1(keyword);
            for (Integer integer : idNyName1) {
                List<Employeeec> list3 = ecDao.getList3(integer);
                employeeecs.add(list3);
            }
            return employeeecs;
        }

        List<Employeeec> list3 = ecDao.getList3(null);
        employeeecs.add(list3);
        return employeeecs;
    }
}
