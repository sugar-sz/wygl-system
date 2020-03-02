package com.sugar.wyglsystem.service.impl.impl;

import com.sugar.wyglsystem.dao.WyglAdminDao;
import com.sugar.wyglsystem.mbg.mapper.WyglAdminMapper;
import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import com.sugar.wyglsystem.mbg.model.WyglAdminExample;
import com.sugar.wyglsystem.service.impl.WyglAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.List;
import java.util.regex.PatternSyntaxException;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 11:11
 * @description： adminServiceImpl
 */
@Service
public class WyglAdminServiceImpl implements WyglAdminService {
    @Autowired
    private WyglAdminMapper wyglAdminMapper;
    @Autowired
    private WyglAdminDao wyglAdminDao;

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
        //查询数据库中是否重名
        WyglAdmin result = wyglAdminDao.selectUserByUsername(wyglAdmin.getUsername());
        if (result != null) {
            return null;
        }
        wyglAdminMapper.insert(wyglAdmin);
        return wyglAdmin;
    }
}
