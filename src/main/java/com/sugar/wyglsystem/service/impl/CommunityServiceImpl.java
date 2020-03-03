package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.mapper.CommunityMapper;
import com.sugar.wyglsystem.mbg.model.Community;
import com.sugar.wyglsystem.mbg.model.CommunityExample;
import com.sugar.wyglsystem.service.CommunityService;
import org.hibernate.validator.internal.util.IdentitySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/3 9:32
 * @description：
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<Community> getCommunityList(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CommunityExample example = new CommunityExample();
        example.createCriteria().andAdminIdEqualTo(id);
        return communityMapper.selectByExample(example);
    }

    @Override
    public int deleteCommunity(Long id) {
        return communityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Community getCommunityById(Long id) {
        return communityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateCommunity(Long id, Community community) {
        community.setCommunityId(id);
        return communityMapper.updateByPrimaryKey(community);
    }

    @Override
    public Community insertCommunity(Community community) {
        community.setCreateTime(new Date());
        communityMapper.insertSelective(community);
        return community;
    }

    @Override
    public int deleteListCommunity(List<Long> idList) {
        int count = 0;
        for(Long id: idList){
            communityMapper.deleteByPrimaryKey(id);
            count++;
        }
        return count;
    }
}
