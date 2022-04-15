package com.wg.pms.controller.department;

import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Department;
import com.wg.pms.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "部门管理")
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @ApiOperation("树形结构返回所有部门信息")
    @GetMapping("list")
    public CommonResult getAllList() {
   List<Department> list = departmentService.getAllList();
        if (list.size()>=1){
            return CommonResult.success(list);
        }else {
            return CommonResult.failed(list);
        }
    }

    @ApiOperation("添加部门")
    @PostMapping("addDep")
    public CommonResult add(@RequestBody Department department){
       int count = departmentService.add(department);
       if (count>0){
           return CommonResult.success(ResponseResult.SUCCESS);
       }
       return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("修改部门")
    @PostMapping("updateDep/{id}")
    public CommonResult update(@PathVariable Integer id,@RequestBody Department department){
        int count = departmentService.update(id,department);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }

    @ApiOperation("根据id删除部门信息")
    @DeleteMapping("deleteById/{id}")
    public CommonResult delete(@PathVariable Integer id){
       int count = departmentService.delete(id);
       if (count>0){
           return CommonResult.success(ResponseResult.DELETE_SUCCESS);
       }
       return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
