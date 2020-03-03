package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.Community;
import com.sugar.wyglsystem.mbg.model.CommunityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityMapper {
    int countByExample(CommunityExample example);

    int deleteByExample(CommunityExample example);

    int deleteByPrimaryKey(Long communityId);

    int insert(Community record);

    int insertSelective(Community record);

    List<Community> selectByExample(CommunityExample example);

    Community selectByPrimaryKey(Long communityId);

    int updateByExampleSelective(@Param("record") Community record, @Param("example") CommunityExample example);

    int updateByExample(@Param("record") Community record, @Param("example") CommunityExample example);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
}