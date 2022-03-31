package com.wg.pms.service.Impl;

import com.wg.pms.dao.AdminRoleDao;
import com.wg.pms.dao.RoleDao;
import com.wg.pms.entity.Menu;
import com.wg.pms.entity.Role;
import com.wg.pms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    AdminRoleDao adminRoleDao;
    @Override
    public List<Menu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<Role> getRoleList(Long adminId) {
        return adminRoleDao.getRoleList(adminId);
    }
}
