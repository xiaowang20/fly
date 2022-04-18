package com.wg.pms.controller.employee;

import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Adjustsalary;
import com.wg.pms.entity.Employeeec;
import com.wg.pms.entity.Employeeremove;
import com.wg.pms.service.EmployeeAdjustSalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "员工调薪")
@RestController
@RequestMapping("EmpAdjustSalary")
public class EmployeeAdjustSalaryController {
    @Autowired
    EmployeeAdjustSalaryService employeeAdjustSalaryService;

    @ApiOperation("条件分页查询")
    @GetMapping("list")
    public CommonResult list(@RequestParam(value = "pageNum",defaultValue = "1") Integer page,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer size,
                             @RequestParam(required = false) Integer eId){
        List<Adjustsalary> list = employeeAdjustSalaryService.list(page,size,eId);
        if (list!=null){
            return CommonResult.success(CommonPage.restPage(list));
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("联表将eid换成名字")
    @GetMapping("list1")
    public CommonResult list1(@RequestParam(value = "pageNum",defaultValue = "1") Integer page,
                              @RequestParam(value = "pageSize",defaultValue = "5") Integer size,
                              @RequestParam(required = false) String keyword){
        List<Adjustsalary> list = employeeAdjustSalaryService.list1(page, size, keyword);
        if (list!=null){
            return CommonResult.success(CommonPage.restPage(list));
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("添加调薪信息")
    @PostMapping("addEmpAdjustSalary")
    public CommonResult add(@RequestBody Adjustsalary adjustsalary){
        int count = employeeAdjustSalaryService.add(adjustsalary);
        if (count>0){
            return CommonResult.success(ResponseResult.ADD_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.ADD_FAILED);
    }
    @ApiOperation("根据id修改员工调薪信息")
    @PutMapping("update/{id}")
    public CommonResult update(@PathVariable Integer id,@RequestBody Adjustsalary adjustsalary){
        adjustsalary.setId(id);
        int count = employeeAdjustSalaryService.update(adjustsalary);
        if (count>0){
            return CommonResult.success(ResponseResult.UPDATE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }

    @ApiOperation("根据id删除员工调薪信息")
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count = employeeAdjustSalaryService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
