package com.wg.pms.controller.employee;

import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Employeeremove;
import com.wg.pms.entity.Employeetrain;
import com.wg.pms.service.EmployeeTrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "员工培训")
@RestController
@RequestMapping("EmpTrain")
public class EmployeeTrainController {
    @Autowired
    EmployeeTrainService employeeTrainService;
    @ApiOperation("条件分页查询")
    @GetMapping("list")
    public CommonResult list(@RequestParam(value = "pageNum",defaultValue = "1") Integer page,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer size,
                             @RequestParam(required = false) Integer eId){
        List<Employeetrain> list = employeeTrainService.list(page,size,eId);
        if (list!=null){
            return CommonResult.success(CommonPage.restPage(list));
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("添加员工培训信息")
    @PostMapping("addEmpTrain")
    public CommonResult add(@RequestBody Employeetrain employeetrain){
        int count = employeeTrainService.add(employeetrain);
        if (count>0){
            return CommonResult.success(ResponseResult.ADD_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.ADD_FAILED);
    }
    @ApiOperation("根据id修改员工培训信息")
    @PutMapping("update/{id}")
    public CommonResult update(@PathVariable Integer id,@RequestBody Employeetrain employeetrain){
        employeetrain.setId(id);
        int count = employeeTrainService.update(employeetrain);
        if (count>0){
            return CommonResult.success(ResponseResult.UPDATE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }

    @ApiOperation("根据id删除员工培训信息")
    @DeleteMapping("delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count = employeeTrainService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
