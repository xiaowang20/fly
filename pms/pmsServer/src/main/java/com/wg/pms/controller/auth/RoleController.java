package com.wg.pms.controller.auth;

import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Role;
import com.wg.pms.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "后台角色管理")
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @ApiOperation("条件分页查询role")
    @GetMapping("list")
    public CommonResult list(@RequestParam(value = "pageNum",defaultValue = "1")Integer page,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer size,
                             @RequestParam(value = "keyword",required = false) String keyword){
        List<Role> list  = roleService.list(page,size,keyword);
        if (list!=null){
            return CommonResult.success(CommonPage.restPage(list));
        }else {
            return CommonResult.failed(ResponseResult.SELECT_FAILED.getMessage());
        }
    }
    @ApiOperation("获取所有角色信息")
    @GetMapping("listAll")
    public CommonResult listAll(){
        List<Role> list  = roleService.listAll();
        if (list!=null){
            return CommonResult.success(list);
        }else {
            return CommonResult.failed(ResponseResult.SELECT_FAILED.getMessage());
        }
    }

    @ApiOperation("添加角色")
    @PostMapping("add")
    public CommonResult addRole(@RequestBody Role role){
       int count = roleService.add(role);
       if (count>0){
           return CommonResult.success(ResponseResult.ADD_SUCCESS.getMessage());
       }
       return CommonResult.failed(ResponseResult.ADD_FAILED.getMessage());
    }
    @ApiOperation("根据RoleId更新角色")
    @PostMapping("updateRole/{id}")
    public CommonResult updateRole(@PathVariable("id")Integer id ,@RequestBody Role role){
        int count = roleService.update(id,role);
        if (count>0){
            return CommonResult.success(ResponseResult.UPDATE_SUCCESS.getMessage());
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED.getMessage());
    }
    @ApiOperation("根据id批量删除角色信息")
    @DeleteMapping("deleteRole")
    public CommonResult updateRole(@RequestParam("roleIds") List<Integer> roleIds){
        int count = roleService.delete(roleIds);
        if (count>0){
            return CommonResult.success(ResponseResult.DELETE_SUCCESS.getMessage());
        }
        return CommonResult.failed(ResponseResult.DELETE_FAILED.getMessage());
    }
}
