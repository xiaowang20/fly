package com.wg.pms.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.wg.pms.common.CommonResult;
import com.wg.pms.dao.AdminRole;
import com.wg.pms.dao.AdminRoleDao;
import com.wg.pms.dao.RoleDao;
import com.wg.pms.entity.*;
import com.wg.pms.mapper.HrMapper;
import com.wg.pms.mapper.HrRoleMapper;
import com.wg.pms.mapper.MenuMapper;
import com.wg.pms.service.HrService;
import com.wg.pms.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HrServiceImpl implements HrService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HrServiceImpl.class);


   private HrMapper hrMapper;
   @Autowired
     public void setHrMapper(HrMapper hrMapper){
       this.hrMapper=hrMapper;
   }
    @Autowired
    MenuMapper menuMapper;
   @Autowired
   AdminRole adminRole;
   @Autowired
    RoleDao roleDao;
   @Autowired
    AdminRoleDao adminRoleDao;
   @Autowired
    HrRoleMapper hrRoleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Hr getAdminByUsername(String username) {
        HrExample example = new HrExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Hr> hrList = hrMapper.selectByExample(example);
        if (hrList != null && hrList.size() > 0) {
            return hrList.get(0);
        }
        return null;
    }


    @Override
    public List<Menu> getPermissionList(long adminId) {
        return adminRole.getAllMenus(adminId);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
//            if(!userDetails.isEnabled()){
//               throw new
//            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateTokenByUsername(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public Hr register(Hr adminParam) {
        Hr admin = new Hr();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setEnabled(true);
        //查询是否有相同用户名的用户
        HrExample example = new HrExample();
        example.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Hr> list = hrMapper.selectByExample(example);
        if (list.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
       int i = hrMapper.insert(admin);
       if (i > 0){
           CommonResult.success("注册成功");
       }
        return admin;
    }

    @Override
    public List<Hr> list(Integer page,Integer size,String keyword) {
        PageHelper.startPage(page,size);
        HrExample hrExample = new HrExample();
        if (StringUtil.isNotEmpty(keyword)){
            hrExample.createCriteria().andUsernameLike("%"+keyword+"%");
            hrExample.or(hrExample.createCriteria().andNameLike("%"+keyword+"%"));
        }
        List<Hr> list = hrMapper.selectByExample(hrExample);
        //使用流，关键 Boolean.FALSE
//        List<Hr> list1 = hrMapper.selectByExample(new HrExample());
//        List<Hr> collect = list1.stream()
//                .filter(a -> Boolean.FALSE ? a.getUsername().equals(keyword) : a.getUsername().contains(keyword))
//                .filter(a->Boolean.FALSE?a.getName().equals(keyword):a.getName().contains(keyword))
//                .collect(Collectors.toList());

        return list;
    }

    @Override
    public int updateStatus(Long id, Hr hr) {
        hr.setId(id);
        Hr rawAdmin = hrMapper.selectByKey(id);
        if(rawAdmin.getPassword().equals(hr.getPassword())){
            //与原加密密码相同的不需要修改
            hr.setPassword(null);
        }else{
            //与原加密密码不同的需要加密修改
            if(StrUtil.isEmpty(hr.getPassword())){
                hr.setPassword(null);
            }else{
                hr.setPassword(passwordEncoder.encode(hr.getPassword()));
            }
        }
        int count = hrMapper.updateByPrimaryKeySelective(hr);
        return count;
    }

    @Override
    public int delete(Long id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Role> getRoleList(Long adminId) {
        return adminRoleDao.getRoleList(adminId);
    }

    @Override
    public int updateRole(Integer adminId, List<Integer> roleIds) {

        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        HrRoleExample adminRoleRelationExample = new HrRoleExample();
        adminRoleRelationExample.createCriteria().andHridEqualTo(adminId);
        hrRoleMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<HrRole> list = new ArrayList<>();
            for (Integer roleId : roleIds) {
                HrRole roleRelation = new HrRole();
                roleRelation.setHrid(adminId);
                roleRelation.setRid(roleId);
                list.add(roleRelation);
            }
            adminRoleDao.insertList(list);
        }
        return count;
    }

}
