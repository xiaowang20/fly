package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.dao.AdminRoleDao;
import com.wg.pms.dao.MenuDao;
import com.wg.pms.dao.RoleDao;
import com.wg.pms.entity.*;
import com.wg.pms.entity.dto.MenuNode;
import com.wg.pms.mapper.MenuRoleMapper;
import com.wg.pms.mapper.RoleMapper;
import com.wg.pms.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    AdminRoleDao adminRoleDao;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    @Autowired
    MenuDao menuDao;
    @Override
    public List<Menu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<Role> getRoleList(Long adminId) {
        return adminRoleDao.getRoleList(adminId);
    }

    @Override
    public List<Role> list(Integer page, Integer size, String keyword) {

        PageHelper.startPage(page,size);
        RoleExample roleExample = new RoleExample();
        if (StringUtil.isNotEmpty(keyword)){
            roleExample.createCriteria().andNameLike("%"+keyword+"%");
            roleExample.or(roleExample.createCriteria().andNamezhLike("%"+keyword+"%"));
        }
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

    @Override
    public List<Role> listAll() {

        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public int add( Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Integer id, Role role) {
        role.setId(id);
        int count = roleMapper.updateByPrimaryKeySelective(role);
        return count;
    }

    @Override
    public int delete(List<Integer> roleIds) {
        //??????mybatis???????????????
//        RoleExample roleExample = new RoleExample();
//        roleExample.createCriteria().andIdIn(roleIds);
//        int count = roleMapper.deleteByExample(roleExample);
        for (Integer roleId : roleIds) {
            roleMapper.deleteByPrimaryKey(roleId);
        }
        return 1;
    }

    @Override
    public int allocMenu(Integer roleId, List<Integer> menuIds) {

        MenuRoleExample menuRoleExample = new MenuRoleExample();
        menuRoleExample.createCriteria().andRidEqualTo(roleId);
        int i = menuRoleMapper.deleteByExample(menuRoleExample);
        for (Integer menuId : menuIds) {
            MenuRole menuRole = new MenuRole();
            menuRole.setRid(roleId);
            menuRole.setMid(menuId);
            menuRoleMapper.insertSelective(menuRole);
        }
        return menuIds.size();

    }

    @Override
    public List<MenuNode> getMenuByRoleId(Integer roleId) {

        return menuDao.getAllMenusByRoleId(roleId);
    }
}
