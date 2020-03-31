package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dao.RoomDao;
import com.sugar.wyglsystem.dto.RoomAndOwnerInfoDto;
import com.sugar.wyglsystem.dto.RoomDto;
import com.sugar.wyglsystem.mbg.mapper.RoomMapper;
import com.sugar.wyglsystem.mbg.model.Room;
import com.sugar.wyglsystem.mbg.model.RoomExample;
import com.sugar.wyglsystem.service.RoomService;
import io.swagger.annotations.ApiOperation;
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
    @Autowired
    private RoomDao roomDao;

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
        int count = roomMapper.insert(room);
        if (count > 0) {
            return room;
        }
        return null;
    }

    @Override
    public RoomDto getRoomByOwnerId(Long id) {
        RoomDto roomDto = new RoomDto();
        RoomExample example = new RoomExample();
        example.createCriteria().andOwnerIdEqualTo(id);
        List<Room> roomList = roomMapper.selectByExample(example);
        if (roomList.size() > 0) {
            roomDto.setList(roomList);
            return roomDto;
        }
        return null;
    }

    @Override
    public Room getRoomById(Long id) {
        return roomMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RoomAndOwnerInfoDto> getRoomAndOwnerInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RoomAndOwnerInfoDto> roomAndOwnerInfoDtoList = roomDao.getRoomAndOwnerInfo();
        if (roomAndOwnerInfoDtoList.size() > 0) {
            return roomAndOwnerInfoDtoList;
        }
        return null;
    }

    @Override
    public int getRoomCount() {
        RoomExample example = new RoomExample();
        example.createCriteria().andOwnerIdIsNotNull();
        return roomMapper.countByExample(example);
    }
}
