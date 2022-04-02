package com.wg.pms.controller.politicsStatus;

import com.wg.pms.common.CommonResult;
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
}
