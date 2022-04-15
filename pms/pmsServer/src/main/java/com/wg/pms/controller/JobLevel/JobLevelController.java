package com.wg.pms.controller.JobLevel;

import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Department;
import com.wg.pms.entity.Joblevel;
import com.wg.pms.service.JobLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "职称")
@RestController
@RequestMapping("JobLevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @ApiOperation("添加职称")
    @PostMapping("addJob")
    public CommonResult add(@RequestBody Joblevel joblevel){
        int count = jobLevelService.add(joblevel);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id添加职称")
    @PostMapping("updateJob/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Joblevel joblevel){
        int count = jobLevelService.update(id,joblevel);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id删除职称信息")
    @DeleteMapping("deleteById/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count = jobLevelService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
