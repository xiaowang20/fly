package com.wg.pms;

import com.wg.pms.common.CommonPage;
import com.wg.pms.dao.EmployeeDao;
import com.wg.pms.dao.MenuDao;
import com.wg.pms.entity.Department;
import com.wg.pms.entity.DepartmentExample;
import com.wg.pms.entity.Employee;
import com.wg.pms.entity.Nation;
import com.wg.pms.entity.vo.EmployeeQueryParams;
import com.wg.pms.mapper.DepartmentMapper;
import com.wg.pms.mapper.RoleMapper;
import com.wg.pms.service.DepartmentService;
import com.wg.pms.service.EmployeeService;
import com.wg.pms.service.MenuService;
import com.wg.pms.service.NationService;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsApplicationTest {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    NationService nationService;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuService menuService;
    @Autowired
    MenuDao menuDao;

    @Test
    public void test2Menu(){
        System.out.println(menuDao.getAllMenusByRoleId(22));
    }

    @Test
    public void testMenu(){
        System.out.println(menuDao.getAllMenuWithOutChildren());
    }
    @Test
    public void test1Menu(){
        System.out.println(menuDao.getAllMenus());
    }
    @Test
    public void test5(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test4(){
        List<Nation> allNations = nationService.getAllNations();
        Nation nation = new Nation("汉族");
        int i = allNations.indexOf(nation);
        System.out.println(i);
    }
    @Test
    public void test3(){
        List<Department> departmentList = departmentService.selectAll(new DepartmentExample());
//        System.out.println(departmentList);
        int indexOf = departmentList.indexOf(new Department("运维部"));
        System.out.println(indexOf);
        System.out.println(departmentList.get(indexOf).getId());
    }

    @Test
    public  String selectNode(String name,Department department ,List<Department> node){

        String collect = node.stream()
                .filter(sub -> sub.getParentid().equals(department.getId()))
                .filter(sub -> sub.getName().equals(name))
                .map(sub -> selectNode(name, sub, node))
                .collect(Collectors.joining());

        return collect;


    }

    @Test
    public void contextLoads() {
        System.out.println("w");
        Employee byPrimaryKey = employeeDao.getByPrimaryKey(1);

        System.out.println("成功"+ byPrimaryKey);
    }
    @Test
    public void test1(){

        Employee employee = new Employee();

        employee.setName("张");
        List<Employee> list = employeeDao.list(1, 1,employee );

        System.out.println("成功："+list);
    }
    @Test
    public void test2(){
        EmployeeQueryParams params = new EmployeeQueryParams();
        params.setDepartmentId(92);
        params.setJobLevelId(16);
        params.setNationId(1);
        params.setPoliticId(5);
        params.setPositionId(34);
        List<Employee> list = employeeService.list(1, 1, params);
        System.out.println(CommonPage.restPage(list));
    }
}
