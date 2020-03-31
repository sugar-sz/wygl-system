package com.sugar.wyglsystem.service.impl;

import com.sugar.wyglsystem.dao.AdminRoleRelationDao;
import com.sugar.wyglsystem.dao.WyglAdminDao;
import com.sugar.wyglsystem.dto.AdminUserDetails;
import com.sugar.wyglsystem.mbg.mapper.WyglAdminMapper;
import com.sugar.wyglsystem.mbg.model.AdminRoleRelation;
import com.sugar.wyglsystem.mbg.model.Role;
import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import com.sugar.wyglsystem.service.WyglAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 11:11
 * @description： adminServiceImpl
 */
@Service
@Transactional
public class WyglAdminServiceImpl implements WyglAdminService{
    @Autowired
    private WyglAdminMapper wyglAdminMapper;
    @Autowired
    private WyglAdminDao wyglAdminDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminRoleRelationDao adminRoleRelationDao;

    @Override
    public WyglAdmin login(String username, String password) {
        WyglAdmin wyglAdmin = wyglAdminDao.selectUserByUsername(username);
        if (wyglAdmin != null) {
            if (wyglAdmin.getPassword().equals(password)) {
                WyglAdmin newAdmin = new WyglAdmin();
                BeanUtils.copyProperties(wyglAdmin, newAdmin);
                newAdmin.setLoginTime(new Date());
                wyglAdminMapper.updateByPrimaryKey(newAdmin);
                return newAdmin;
            }
        }
        return null;
    }

    @Override
    public WyglAdmin register(WyglAdmin wyglAdminParam) {
        WyglAdmin wyglAdmin = new WyglAdmin();
        BeanUtils.copyProperties(wyglAdminParam, wyglAdmin);
        wyglAdmin.setCreateTime(new Date());
        wyglAdmin.setStatus(1);
        System.out.println(wyglAdmin);
        //查询数据库中是否重名
        WyglAdmin result = wyglAdminDao.selectUserByUsername(wyglAdmin.getUsername());
        if (result != null) {
            System.out.println(22);
            return null;
        }
        wyglAdmin.setPassword(passwordEncoder.encode(wyglAdmin.getPassword()));
        wyglAdminMapper.insert(wyglAdmin);
        return wyglAdmin;
    }

    @Override
    public WyglAdmin getAdminById(Long id) {
        return wyglAdminMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        WyglAdmin wyglAdmin = wyglAdminDao.selectUserByUsername(s);
        if (wyglAdmin == null) {
            throw new UsernameNotFoundException("用户名未找到");
        }
        List<Role> roleList = adminRoleRelationDao.getRoleList(wyglAdmin.getId());
        return new AdminUserDetails(wyglAdmin,roleList);
    }
}
