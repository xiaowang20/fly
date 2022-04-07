package com.wg.pms.controller.employee;


import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Employee;
import com.wg.pms.entity.vo.EmployeeQueryParams;
import com.wg.pms.service.EmployeeService;
import com.wg.pms.service.PoliticsStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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


    @ApiOperation("分页条件查询员工详情")
    @PostMapping(value = "/listPageQuery",produces = "application/json")
    public CommonResult<CommonPage<Employee>> list(@RequestParam(value = "pageNum",defaultValue = "1") int page,
                                                   @RequestParam(value = "pageSize",defaultValue = "10") int size,
                                                   @RequestBody EmployeeQueryParams queryParams
                                                   ){

        List<Employee> employeeList =  employeeService.list(page,size,queryParams);
        System.out.println("条件查询标记一下");
        System.out.println(employeeList);
        return CommonResult.success(CommonPage.restPage(employeeList));
    }
    @ApiOperation("获取员工所有信息")
    @GetMapping("/getAllEmp")
    public CommonResult<CommonPage<Employee>> getAllEmp(@RequestParam(value = "pageNum",defaultValue = "1") int page,
                                                        @RequestParam(value = "pageSize",defaultValue = "10") int size,
                                                        @RequestParam(value = "keyword",required = false) String keyword
                                                        ){

        List<Employee> employeeList =  employeeService.getAllEmp(page,size,keyword);
        System.out.println("查询标记一下");

        return CommonResult.success(CommonPage.restPage(employeeList));
    }

    @ApiOperation("根据id删除员工")
    @DeleteMapping("/delete/{id}")
    public CommonResult deleteEmpById(@PathVariable("id") Integer id){
            if (employeeService.delete(id)==1){
                return CommonResult.success(ResponseResult.DELETE_SUCCESS.getMessage());
            }else{
                return CommonResult.failed(ResponseResult.DELETE_FAILED.getMessage());
            }
    }

    @ApiOperation("添加员工")
    @PostMapping("/add")
    public CommonResult addEmp(@RequestBody Employee employee){
       if (employeeService.add(employee) == 1){
           return CommonResult.success(ResponseResult.ADD_SUCCESS.getMessage());
       }else {
           return CommonResult.failed(ResponseResult.ADD_FAILED.getMessage());
       }
    }

    @ApiOperation("更新员工")
    @PutMapping("/update")
    public CommonResult update(@RequestBody Employee employee){
        if (employeeService.update(employee) == 1){
            return CommonResult.success(ResponseResult.UPDATE_SUCCESS.getMessage());
        }else {
            return CommonResult.success(ResponseResult.UPDATE_FAILED.getMessage());
        }
    }
}
