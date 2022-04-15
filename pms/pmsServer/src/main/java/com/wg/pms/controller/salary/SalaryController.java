package com.wg.pms.controller.salary;

import com.github.pagehelper.util.StringUtil;
import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Position;
import com.wg.pms.entity.Salary;
import com.wg.pms.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "薪资管理")
@RestController
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @ApiOperation("条件分页查询薪资信息")
    @PostMapping("list")
    public CommonResult list(@RequestParam(value = "pageNum",defaultValue = "1") Integer page,
                                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer size,
                                                 @RequestParam("keyword")String keyword){
       List<Salary> list = salaryService.list(page,size,keyword);
       if (list!=null){
           return CommonResult.success(CommonPage.restPage(list));
       }
       return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }

    @ApiOperation("添加薪资信息")
    @PostMapping("addSalary")
    public CommonResult add(@RequestBody Salary salary){
        int count = salaryService.add(salary);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id修改薪资信息")
    @PostMapping("updateSalary/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Salary salary){
        int count = salaryService.update(id,salary);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }
    @ApiOperation("根据id删除薪资信息")
    @DeleteMapping("deleteById/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count = salaryService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
