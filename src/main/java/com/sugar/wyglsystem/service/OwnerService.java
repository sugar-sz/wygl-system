package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.OwnerDto;
import com.sugar.wyglsystem.mbg.model.Owner;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/4 10:22
 * @description： 业主信息管理
 */
public interface OwnerService {
    List<Owner> getOwnerList(Integer pageNum, Integer pageSize);

    int deleteOwner(Long id);

    OwnerDto getOwnerById(Long id);

    List<Owner> getOwnerByName(String name, Integer pageNum, Integer pageSize);

    int updateOwner(Long id, Owner owner);

    Owner insertOwner(Owner owner);

    int getOwnerCount();
}
