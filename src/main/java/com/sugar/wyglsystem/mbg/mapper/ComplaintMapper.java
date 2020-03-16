package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.Complaint;
import com.sugar.wyglsystem.mbg.model.ComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintMapper {
    int countByExample(ComplaintExample example);

    int deleteByExample(ComplaintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    List<Complaint> selectByExample(ComplaintExample example);

    Complaint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}