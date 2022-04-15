package com.wg.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wg.pms.dao.MenuDao;
import com.wg.pms.entity.Menu;
import com.wg.pms.entity.MenuExample;
import com.wg.pms.entity.dto.MenuNode;
import com.wg.pms.mapper.MenuMapper;
import com.wg.pms.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuDao menuDao;
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
        menu.setRequireauth(requireAuth);
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int add(Menu menu) {

        menu.setEnabled(true);
        menu.setKeepalive(true);
        menu.setRequireauth(true);
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

    @Override
    public int delete(Integer id) {

        try {
            return menuMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

//    @Override
//    public List<MenuNode> treeList() {
//
//        List<Menu> RootList = menuMapper.selectByExample(new MenuExample());
//        List<MenuNode> menuList = RootList.stream()
//                .filter(root -> root.getParentId().equals(0))
//                .map(root -> treeNode(root, RootList))
//                .collect(Collectors.toList());
//        return menuList;
//    }

    @Override
    public List<MenuNode> tree1List() {

      List<MenuNode> list = menuDao.getAllMenuWithOutChildren();
      return list;
//        List<MenuNode> result = list.stream()
//                .filter(root -> root.getParentid().equals(""))
//                .map(root -> treeNode(root, list))
//                .collect(Collectors.toList());
//        return result;
    }

    @Override
    public List<MenuNode> tree2List() {
        return menuDao.getAllMenus();
    }

//    private MenuNode treeNode(MenuNode menuRoot,List<MenuNode> listNode){
//        MenuNode menuNode = new MenuNode();
//        BeanUtils.copyProperties(menuRoot,menuNode);
//        List<MenuNode> collect = listNode.stream()
//                .filter(node -> node.getParentid().equals(menuRoot.getId()))
//                .map(node -> treeNode(node, listNode))
//                .collect(Collectors.toList());
//        menuNode.setChildren(collect);
//        return menuNode;
//    }
}
