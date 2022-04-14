package com.wg.pms.controller.auth;

import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Role;
import com.wg.pms.service.HrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xmlunit.diff.ComparisonResult;

import java.util.List;

@Api(tags = "后台用户管理")
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    HrService hrService;
    @ApiOperation("条件分页查询admin")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "pageNum",defaultValue = "1")Integer page,
                                             @RequestParam(value = "pageSize",defaultValue = "5") Integer size,
                                             @RequestParam(value = "keyword",required = false) String keyword){
       List<Hr> list  = hrService.list(page,size,keyword);
       if (list!=null){
           return CommonResult.success(CommonPage.restPage(list));
       }else {
           return CommonResult.failed(ResponseResult.SELECT_FAILED.getMessage());
       }
    }
    @ApiOperation("修改用户状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult updateStatus(@PathVariable("id")Long id, @RequestParam("status") Boolean status ){
        Hr hr = new Hr();
        hr.setEnabled(status);
       int count = hrService.updateStatus(id,hr);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }

    @ApiOperation("根据id修改用户")
    @PostMapping("updateAdmin/{id}")
    public CommonResult update(@PathVariable("id") Long id,@RequestBody Hr hr){
       int count =  hrService.updateStatus(id,hr);
       if (count>0){
           return CommonResult.success(ResponseResult.UPDATE_SUCCESS.getMessage());
       }
       return CommonResult.failed(ResponseResult.UPDATE_FAILED.getMessage());
    }
    @ApiOperation("根据id删除指定用户")
    @DeleteMapping("deleteAdmin/{id}")
    public CommonResult delete(@PathVariable("id") Long id){
       int count = hrService.delete(id);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS.getMessage());
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED.getMessage());
    }
    @ApiOperation("根据adminId获取角色信息")
    @GetMapping("getRoleList/{adminId}")
    public CommonResult getRoleList(@PathVariable("adminId") Long adminId){
       List<Role> roleList = hrService.getRoleList(adminId);
       if (roleList!=null){
           return CommonResult.success(roleList);
       }
       return CommonResult.failed(ResponseResult.SELECT_FAILED.getMessage());
    }

    @ApiOperation("分配角色")
    @PostMapping("role/update")
    public CommonResult updateRole(@RequestParam("adminId") Integer adminId,
                                   @RequestParam("roleIds") List<Integer> roleIds){
       int count = hrService.updateRole(adminId,roleIds);
        if (count>0){
            return CommonResult.success(ResponseResult.UPDATE_SUCCESS.getMessage());
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED.getMessage());
    }
}
