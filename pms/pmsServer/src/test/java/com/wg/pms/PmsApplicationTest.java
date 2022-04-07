package com.wg.pms;

import com.wg.pms.common.CommonPage;
import com.wg.pms.dao.EmployeeDao;
import com.wg.pms.entity.Employee;
import com.wg.pms.entity.vo.EmployeeQueryParams;
import com.wg.pms.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsApplicationTest {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    EmployeeService employeeService;
    @Test
    public void contextLoads() {
        System.out.println("w");
        Employee byPrimaryKey = employeeDao.getByPrimaryKey(1);

        System.out.println("成功"+ byPrimaryKey);
    }
//    @Test
//    public void test1(){
//        EmployeeQueryParams params = new EmployeeQueryParams();
//        params.setName("云星");
//        List<Employee> list = employeeDao.list(1, 1, params);
//        System.out.println("成功："+list);
//    }
//    @Test
//    public void test2(){
//        EmployeeQueryParams params = new EmployeeQueryParams();
//        params.setName("姚森");
//        List<Employee> list = employeeService.list(1, 1, params);
//        System.out.println(CommonPage.restPage(list));
//    }
}
