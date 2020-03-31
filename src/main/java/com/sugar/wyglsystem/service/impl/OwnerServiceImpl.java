package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.OwnerDto;
import com.sugar.wyglsystem.mbg.mapper.OwnerMapper;
import com.sugar.wyglsystem.mbg.model.Owner;
import com.sugar.wyglsystem.mbg.model.OwnerExample;
import com.sugar.wyglsystem.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/4 10:24
 * @description：
 */
@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<Owner> getOwnerList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Owner> ownerList = ownerMapper.selectByExample(new OwnerExample());
        if (ownerList.size() > 0) {
            return ownerList;
        }
        return null;
    }

    @Override
    public int deleteOwner(Long id) {
        return ownerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public OwnerDto getOwnerById(Long id) {
        OwnerDto ownerDto = new OwnerDto();
        List<Owner> ownerList = new ArrayList<>();
        Owner owner = ownerMapper.selectByPrimaryKey(id);
        if (owner != null) {
            ownerList.add(owner);
            ownerDto.setList(ownerList);
            return ownerDto;
        }
        return null;
    }

    @Override
    public List<Owner> getOwnerByName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OwnerExample example = new OwnerExample();
        example.createCriteria().andNameLike("%" + name + "%");
        List<Owner> ownerList = ownerMapper.selectByExample(example);
        if (ownerList.size() == 0) {
            return null;
        }
        return ownerList;
    }

    @Override
    public int updateOwner(Long id, Owner owner) {
        owner.setId(id);
        return ownerMapper.updateByPrimaryKey(owner);
    }

    @Override
    public Owner insertOwner(Owner owner) {
        owner.setCreateTime(new Date());
        owner.setStatus(1);
        ownerMapper.insert(owner);
        return owner;
    }

    @Override
    public int getOwnerCount() {
        return ownerMapper.countByExample(new OwnerExample());
    }
}
