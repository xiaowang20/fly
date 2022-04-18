package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.dao.EmpRemoveDao;
import com.wg.pms.dao.EmpTrainDao;
import com.wg.pms.entity.Employeeremove;
import com.wg.pms.entity.Employeetrain;
import com.wg.pms.entity.EmployeetrainExample;
import com.wg.pms.mapper.EmployeetrainMapper;
import com.wg.pms.service.EmployeeService;
import com.wg.pms.service.EmployeeTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeTrainServiceImpl implements EmployeeTrainService {
    @Autowired
    EmployeetrainMapper employeetrainMapper;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmpTrainDao empTrainDao;
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

    @Override
    public List<Employeetrain> list1(Integer page, Integer size, String keyword) {

        PageHelper.startPage(page,size);
        List<Employeetrain>  employeetrains = new ArrayList<>();
        if (StringUtil.isNotEmpty(keyword)){
            List<Integer> idNyName1 = employeeService.getIdNyName1(keyword);
            for (Integer integer : idNyName1) {
                Employeetrain list3 = empTrainDao.getList1(integer);
                if(list3!=null){
                    employeetrains.add(list3);
                }

            }
            return employeetrains;
        }

        List<Employeetrain> list2 = empTrainDao.getList2(null);

        return list2;
    }
}
