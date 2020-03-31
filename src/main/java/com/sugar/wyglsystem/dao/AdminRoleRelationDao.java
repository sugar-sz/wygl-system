package com.sugar.wyglsystem.dao;

import com.sugar.wyglsystem.mbg.model.Role;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/21 10:21
 * @description：
 */
public interface AdminRoleRelationDao {
    List<Role> getRoleList(Long id);
}
