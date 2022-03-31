package com.wg.pms.controller;

import cn.hutool.core.collection.CollUtil;
import com.wg.pms.common.CommonResult;
import com.wg.pms.entity.Hr;
import com.wg.pms.entity.Menu;
import com.wg.pms.entity.Role;
import com.wg.pms.entity.vo.AdminLoginParam;
import com.wg.pms.service.HrService;
import com.wg.pms.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        Hr admin = hrService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
        data.put("menus", roleService.getMenuList(admin.getId()));
        data.put("icon", admin.getUserface());
        List<Role> roleList = roleService.getRoleList(admin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return CommonResult.success(data);
    }
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<Hr> register(@RequestBody Hr adminParam, BindingResult result) {
        Hr admin = hrService.register(adminParam);
        if (admin == null) {
            CommonResult.failed("注册失败");
        }
        return CommonResult.success(admin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody AdminLoginParam adminLoginParam, BindingResult result) {
        String token = hrService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<Menu>> getPermissionList(@PathVariable long adminId) {
        List<Menu> permissionList = hrService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
