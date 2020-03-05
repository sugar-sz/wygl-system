package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.Building;
import com.sugar.wyglsystem.mbg.model.BuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingMapper {
    int countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Building record);

    int insertSelective(Building record);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}