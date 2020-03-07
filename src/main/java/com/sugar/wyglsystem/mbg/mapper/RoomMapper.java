package com.sugar.wyglsystem.mbg.mapper;

import com.sugar.wyglsystem.mbg.model.Room;
import com.sugar.wyglsystem.mbg.model.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    int countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}