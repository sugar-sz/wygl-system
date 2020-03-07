package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.RoomDto;
import com.sugar.wyglsystem.mbg.mapper.RoomMapper;
import com.sugar.wyglsystem.mbg.model.Room;
import com.sugar.wyglsystem.mbg.model.RoomExample;
import com.sugar.wyglsystem.mbg.model.Unit;
import com.sugar.wyglsystem.service.RoomService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ： Created in 2020/3/7 14:55
 * @description：
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> getRoomList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Room> roomList = roomMapper.selectByExample(new RoomExample());
        if (roomList.size() > 0) {
            return roomList;
        }
        return null;
    }

    @Override
    public int deleteRoomById(Long id) {
        return roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateRoom(Long id, Room room) {
        room.setId(id);
        return roomMapper.updateByPrimaryKey(room);
    }

    @Override
    public RoomDto getRoomByNumber(Long buildingNumber, Long unitNumber, Long roomNumber) {
        RoomDto roomDto = new RoomDto();
        RoomExample example = new RoomExample();
        example.createCriteria()
                .andNumberEqualTo(roomNumber)
                .andBuildingNumberEqualTo(buildingNumber)
                .andUnitNumberEqualTo(unitNumber);
        List<Room> roomList = roomMapper.selectByExample(example);
        if (roomList.size() > 0) {
            roomDto.setList(roomList);
            return roomDto;
        }
        return null;
    }

    @Override
    public List<Room> getRoomInfoByBuildingNumber(Long buildingNum, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RoomExample example = new RoomExample();
        example.createCriteria().andBuildingNumberEqualTo(buildingNum);
        List<Room> roomList = roomMapper.selectByExample(example);
        if (roomList.size() > 0) {
            return roomList;
        }
        return null;
    }

    @Override
    public Room insertRoom(Room room) {
        room.setCreateTime(new Date());
        room.setStatus(0);
        int count = roomMapper.insert(room);
        if (count > 0) {
            return room;
        }
        return null;
    }
}
