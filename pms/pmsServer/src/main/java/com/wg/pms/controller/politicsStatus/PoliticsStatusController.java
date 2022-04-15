package com.wg.pms.controller.politicsStatus;

import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Department;
import com.wg.pms.entity.Politicsstatus;
import com.wg.pms.service.PoliticsStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/politicsStatus")
@Api(tags = "政治面貌")
public class PoliticsStatusController {
    @Autowired
    PoliticsStatusService politicsStatusService;
    @ApiOperation("根据id获取政治面貌信息")
    @GetMapping("/getAllPoliticsStatus/{id}")
    public CommonResult getAllPoliticsStatus(@PathVariable Integer id){
     List<Politicsstatus>  politicsstatus = politicsStatusService.list(id);
       return CommonResult.success(politicsstatus);
   }

    @ApiOperation("添加政治面貌")
    @PostMapping("addPolitics")
    public CommonResult add(@RequestBody Politicsstatus politicsstatus){
        int count = politicsStatusService.add(politicsstatus);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id修改政治面貌")
    @PostMapping("updatePolitics/{id}")
    public CommonResult update(@PathVariable Integer id,@RequestBody Politicsstatus politicsstatus){
        int count = politicsStatusService.update(id,politicsstatus);
        if (count>0){
            return CommonResult.success(ResponseResult.SUCCESS);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED);
    }
    @ApiOperation("根据id删除政治面貌信息")
    @DeleteMapping("deleteById/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count = politicsStatusService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS);
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED);
    }
}
