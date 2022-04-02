package com.wg.pms.controller.employee;

import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.RespPageBean;
import com.wg.pms.entity.Employee;
import com.wg.pms.entity.Politicsstatus;
import com.wg.pms.service.EmployeeService;
import com.wg.pms.service.PoliticsStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 员工详情Controller
 */
@RestController
@RequestMapping("/Emp")
@Api(tags = "员工详情")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    PoliticsStatusService politicsStatusService;

    @ApiOperation("简单查询")
    @GetMapping("/getEmpQuery")
    public CommonResult<CommonPage<Employee>> list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                   @RequestParam(value = "size",defaultValue = "10") Integer size,
                                                   @RequestParam(required = false) String keyword
                                                   ){
      List<Employee> list = employeeService.getEmp(page,size,keyword);
      return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("分页条件查询员工详情")
    @PostMapping("/listPageQuery")
    public CommonResult<CommonPage<Employee>> list(@RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size,
                                                   Employee employee){

        List<Employee> employeeList =  employeeService.list(page,size,employee);
        return CommonResult.success(CommonPage.restPage(employeeList));
    }
    @ApiOperation("获取员工所有信息")
    @GetMapping("/getAllEmp")
    public CommonResult<CommonPage<Employee>> getAllEmp(@RequestParam(value = "pageNum",defaultValue = "1") int page,
                                                        @RequestParam(value = "size",defaultValue = "10") int size,
                                                        @RequestParam(required = false) String keyword
                                                        ){

        List<Employee> employeeList =  employeeService.getAllEmp(page,size,keyword);
        return CommonResult.success(CommonPage.restPage(employeeList));
    }


}
