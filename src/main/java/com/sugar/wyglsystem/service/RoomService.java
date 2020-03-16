package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.RoomAndOwnerInfoDto;
import com.sugar.wyglsystem.dto.RoomDto;
import com.sugar.wyglsystem.dto.UnitDto;
import com.sugar.wyglsystem.mbg.model.Room;
import com.sugar.wyglsystem.mbg.model.Unit;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/7 14:52
 * @description： 房屋管理
 */
public interface RoomService {
    List<Room> getRoomList(Integer pageNum, Integer pageSize);

    int deleteRoomById(Long id);

    int updateRoom(Long id, Room room);

    RoomDto getRoomByNumber(Long buildingNumber,Long unitNumber,Long roomNumber);

    List<Room> getRoomInfoByBuildingNumber(Long buildingNum,Integer pageNum,Integer pageSize);

    Room insertRoom(Room room);

    RoomDto getRoomByOwnerId(Long id);

    Room getRoomById(Long id);

    List<RoomAndOwnerInfoDto> getRoomAndOwnerInfo(Integer pageNum,Integer pageSize);
}
