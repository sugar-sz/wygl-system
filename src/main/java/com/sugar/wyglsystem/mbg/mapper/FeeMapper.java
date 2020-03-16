package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.Fee;
import com.sugar.wyglsystem.mbg.model.FeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeMapper {
    int countByExample(FeeExample example);

    int deleteByExample(FeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Fee record);

    int insertSelective(Fee record);

    List<Fee> selectByExample(FeeExample example);

    Fee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Fee record, @Param("example") FeeExample example);

    int updateByExample(@Param("record") Fee record, @Param("example") FeeExample example);

    int updateByPrimaryKeySelective(Fee record);

    int updateByPrimaryKey(Fee record);
}