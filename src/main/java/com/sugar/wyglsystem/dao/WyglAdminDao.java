package com.sugar.wyglsystem.dao;

import com.sugar.wyglsystem.mbg.model.WyglAdmin;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 11:28
 * @description： 自定义Mapper
 */
public interface WyglAdminDao {
    WyglAdmin selectUserByUsername(String username);
}
