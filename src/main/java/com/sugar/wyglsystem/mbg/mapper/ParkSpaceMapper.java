package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.ParkSpace;
import com.sugar.wyglsystem.mbg.model.ParkSpaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkSpaceMapper {
    int countByExample(ParkSpaceExample example);

    int deleteByExample(ParkSpaceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParkSpace record);

    int insertSelective(ParkSpace record);

    List<ParkSpace> selectByExample(ParkSpaceExample example);

    ParkSpace selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParkSpace record, @Param("example") ParkSpaceExample example);

    int updateByExample(@Param("record") ParkSpace record, @Param("example") ParkSpaceExample example);

    int updateByPrimaryKeySelective(ParkSpace record);

    int updateByPrimaryKey(ParkSpace record);
}