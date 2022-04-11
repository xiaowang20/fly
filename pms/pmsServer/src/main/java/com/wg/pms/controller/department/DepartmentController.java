package com.wg.pms.controller.department;

import com.wg.pms.common.CommonResult;
import com.wg.pms.entity.Department;
import com.wg.pms.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
