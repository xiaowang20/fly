package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wg.pms.entity.Menu;
import com.wg.pms.entity.MenuExample;
import com.wg.pms.mapper.MenuMapper;
import com.wg.pms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> list(Integer parentId, Integer page, Integer size) {

        PageHelper.startPage(page,size);
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentidEqualTo(parentId);
        return menuMapper.selectByExample(menuExample);
    }

    @Override
    public int updateStatus(Integer id, Boolean status) {
        Menu menu = new Menu();
        menu.setEnabled(status);
        menu.setId(id);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int updateKeepAlive(Integer id, Boolean keepAlive) {
        Menu menu = new Menu();
        menu.setId(id);
        menu.setKeepalive(keepAlive);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int updateRequireAuth(Integer id, Boolean requireAuth) {

        Menu menu = new Menu();
        menu.setId(id);
        menu.setRequireAuth(requireAuth);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int add(Menu menu) {

        menu.setEnabled(true);
        menu.setKeepalive(true);
        menu.setRequireAuth(true);
        return menuMapper.insert(menu);
    }

    @Override
    public int update(Integer id, Menu menu) {
        menu.setId(id);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public Menu getMenuById(Integer id) {

        Menu menu = menuMapper.selectByPrimaryKey(id);
            return menu;
    }
}
