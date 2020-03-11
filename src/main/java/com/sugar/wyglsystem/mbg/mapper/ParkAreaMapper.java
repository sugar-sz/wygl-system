package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.ParkArea;
import com.sugar.wyglsystem.mbg.model.ParkAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkAreaMapper {
    int countByExample(ParkAreaExample example);

    int deleteByExample(ParkAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParkArea record);

    int insertSelective(ParkArea record);

    List<ParkArea> selectByExample(ParkAreaExample example);

    ParkArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParkArea record, @Param("example") ParkAreaExample example);

    int updateByExample(@Param("record") ParkArea record, @Param("example") ParkAreaExample example);

    int updateByPrimaryKeySelective(ParkArea record);

    int updateByPrimaryKey(ParkArea record);
}