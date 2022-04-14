package com.wg.pms.controller.auth;

import com.wg.pms.common.CommonPage;
import com.wg.pms.common.CommonResult;
import com.wg.pms.common.ResponseResult;
import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Menu;
import com.wg.pms.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "后台菜单管理")
@RestController
@RequestMapping("menu")
public class MenuController {
@Autowired
    MenuService menuService;

    /**
     * 为什么跟admin不一样,不需要根据keyword模糊查询，是因为menu有子数据，前端通过parentId查询子数据。
     * @param parentId
     * @param page
     * @param size
     * @return
     */
    @ApiOperation("条件分页查询菜单")
    @GetMapping("list/{parentId}")
    public CommonResult list(@PathVariable("parentId") Integer parentId, @RequestParam(value = "pageNum",defaultValue = "1")Integer page,@RequestParam(value = "pageSize",defaultValue = "5")Integer size){
      List<Menu> list =  menuService.list(parentId,page,size);
        if (list!=null){
            return CommonResult.success(CommonPage.restPage(list));
        }else {
            return CommonResult.failed(ResponseResult.SELECT_FAILED.getMessage());
        }
    }
    @ApiOperation("修改菜单状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult updateStatus(@PathVariable("id")Integer id, @RequestParam("status") Boolean status ){
        int count = menuService.updateStatus(id,status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }
    @ApiOperation("修改菜单keepAlive")
    @PostMapping("/updateKeepAlive/{id}")
    public CommonResult updateKeepAlive(@PathVariable("id")Integer id, @RequestParam("keepalive") Boolean keepAlive ){
        int count = menuService.updateKeepAlive(id,keepAlive);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }

    @ApiOperation("修改菜单requireAuth")
    @PostMapping("/updateRequireAuth/{id}")
    public CommonResult updateRequireAuth(@PathVariable("id")Integer id, @RequestParam("requireAuth") Boolean requireAuth ){
        int count = menuService.updateRequireAuth(id,requireAuth);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED);
    }

    @ApiOperation("添加菜单")
    @PostMapping("addMenu")
    public CommonResult addMenu(@RequestBody Menu menu){
        int count = menuService.add(menu);
        if (count>0){
            return CommonResult.success(ResponseResult.ADD_SUCCESS.getMessage());
        }
        return CommonResult.failed(ResponseResult.ADD_FAILED.getMessage());
    }

    @ApiOperation("根据id修改菜单")
    @PostMapping("updateMenu/{id}")
    public CommonResult updateMenu(@PathVariable("id") Integer id,@RequestBody Menu menu){
        int count = menuService.update(id,menu);
        if (count>0){
            return CommonResult.success(ResponseResult.UPDATE_SUCCESS.getMessage());
        }
        return CommonResult.failed(ResponseResult.UPDATE_FAILED.getMessage());
    }
    @ApiOperation("根据id获取指定菜单")
    @GetMapping("getMenuById/{id}")
    public CommonResult getMenuById(@PathVariable("id") Integer id){
        Menu menu = menuService.getMenuById(id);
        if (menu!=null){
            return CommonResult.success(menu);
        }
        return CommonResult.failed(ResponseResult.SELECT_FAILED.getMessage());
    }
}
