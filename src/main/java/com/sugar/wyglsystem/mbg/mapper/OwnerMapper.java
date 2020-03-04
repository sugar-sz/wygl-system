package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.Owner;
import com.sugar.wyglsystem.mbg.model.OwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OwnerMapper {
    int countByExample(OwnerExample example);

    int deleteByExample(OwnerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Owner record);

    int insertSelective(Owner record);

    List<Owner> selectByExample(OwnerExample example);

    Owner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Owner record, @Param("example") OwnerExample example);

    int updateByExample(@Param("record") Owner record, @Param("example") OwnerExample example);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);
}