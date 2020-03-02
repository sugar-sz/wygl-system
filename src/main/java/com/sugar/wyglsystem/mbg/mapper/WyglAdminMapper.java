package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import com.sugar.wyglsystem.mbg.model.WyglAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyglAdminMapper {
    int countByExample(WyglAdminExample example);

    int deleteByExample(WyglAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WyglAdmin record);

    int insertSelective(WyglAdmin record);

    List<WyglAdmin> selectByExample(WyglAdminExample example);

    WyglAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WyglAdmin record, @Param("example") WyglAdminExample example);

    int updateByExample(@Param("record") WyglAdmin record, @Param("example") WyglAdminExample example);

    int updateByPrimaryKeySelective(WyglAdmin record);

    int updateByPrimaryKey(WyglAdmin record);
}