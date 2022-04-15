package com.wg.pms.controller.position;

import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Politicsstatus;
import com.wg.pms.entity.Position;
import com.wg.pms.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "职位")
@RestController
@RequestMapping("Position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @ApiOperation("添加职位")
    @PostMapping("addPosition")
    public CommonResult add(@RequestBody Position position){
        int count = positionService.add(position);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id修改职位")
    @PostMapping("updatePosition/{id}")
    public CommonResult update(@PathVariable Integer id, @RequestBody Position position){
        int count = positionService.update(id,position);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id删除职位信息")
    @DeleteMapping("deleteById/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count = positionService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
