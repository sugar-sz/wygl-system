package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.FeeDetails;
import com.sugar.wyglsystem.mbg.model.FeeDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeDetailsMapper {
    int countByExample(FeeDetailsExample example);

    int deleteByExample(FeeDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FeeDetails record);

    int insertSelective(FeeDetails record);

    List<FeeDetails> selectByExample(FeeDetailsExample example);

    FeeDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FeeDetails record, @Param("example") FeeDetailsExample example);

    int updateByExample(@Param("record") FeeDetails record, @Param("example") FeeDetailsExample example);

    int updateByPrimaryKeySelective(FeeDetails record);

    int updateByPrimaryKey(FeeDetails record);
}