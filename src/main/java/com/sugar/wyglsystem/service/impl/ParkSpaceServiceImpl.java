package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.ParkSpaceDto;
import com.sugar.wyglsystem.mbg.mapper.ParkSpaceMapper;
import com.sugar.wyglsystem.mbg.model.ParkArea;
import com.sugar.wyglsystem.mbg.model.ParkSpace;
import com.sugar.wyglsystem.mbg.model.ParkSpaceExample;
import com.sugar.wyglsystem.service.ParkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 18:59
 * @description：
 */
@Service
public class ParkSpaceServiceImpl implements ParkSpaceService {
    @Autowired
    private ParkSpaceMapper parkSpaceMapper;

    @Override
    public List<ParkSpace> getParkSpaceList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ParkSpace> parkSpaceList = parkSpaceMapper.selectByExample(new ParkSpaceExample());
        if (parkSpaceList.size() > 0) {
            return parkSpaceList;
        }
        return null;
    }

    @Override
    public int deleteParkSpace(Long id) {
        return parkSpaceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ParkSpaceDto getParkSpaceById(Long id) {
        ParkSpaceDto parkSpaceDto = new ParkSpaceDto();
        List<ParkSpace> parkSpaceList = new ArrayList<>();
        ParkSpace parkSpace = parkSpaceMapper.selectByPrimaryKey(id);
        if (parkSpace != null) {
            parkSpaceList.add(parkSpace);
            parkSpaceDto.setList(parkSpaceList);
            return parkSpaceDto;
        }
        return null;
    }

    @Override
    public ParkSpaceDto getParkSpaceByNumber(Long id) {
        ParkSpaceDto parkSpaceDto = new ParkSpaceDto();
        ParkSpaceExample example = new ParkSpaceExample();
        example.createCriteria().andNumberEqualTo(id);
        List<ParkSpace> parkSpaceList = parkSpaceMapper.selectByExample(example);
        if (parkSpaceList.size() > 0) {
            parkSpaceDto.setList(parkSpaceList);
            return parkSpaceDto;
        }
        return null;
    }

    @Override
    public ParkSpaceDto getParkSpaceByStatus(Integer id) {
        ParkSpaceDto parkSpaceDto = new ParkSpaceDto();
        ParkSpaceExample example = new ParkSpaceExample();
        example.createCriteria().andStatusEqualTo(id);
        List<ParkSpace> parkSpaceList = parkSpaceMapper.selectByExample(example);
        if (parkSpaceList.size() > 0) {
            parkSpaceDto.setList(parkSpaceList);
            return parkSpaceDto;
        }
        return null;
    }

    @Override
    public int updateParkSpace(Long id, ParkSpace ParkSpace) {
        ParkSpace.setId(id);
        return parkSpaceMapper.updateByPrimaryKey(ParkSpace);
    }

    @Override
    public ParkSpace insertParkSpace(ParkSpace parkSpace) {
        parkSpace.setCreateTime(new Date());
        parkSpace.setStatus(0);
        parkSpaceMapper.insert(parkSpace);
        return parkSpace;
    }

    @Override
    public ParkSpaceDto getParkSpaceByParkAreaNumber(Long number) {
        ParkSpaceDto parkSpaceDto = new ParkSpaceDto();
        ParkSpaceExample example = new ParkSpaceExample();
        example.createCriteria().andParkAreaNumberEqualTo(number);
        List<ParkSpace> parkSpaceList = parkSpaceMapper.selectByExample(example);
        if (parkSpaceList.size() > 0) {
            parkSpaceDto.setList(parkSpaceList);
            return parkSpaceDto;
        }
        return null;
    }

    @Override
    public int countRemainingParkSpace() {
        ParkSpaceExample example = new ParkSpaceExample();
        example.createCriteria().andStatusEqualTo(0);
        int count = parkSpaceMapper.countByExample(example);
        return count;
    }

    @Override
    public int countTotal() {
        return parkSpaceMapper.countByExample(new ParkSpaceExample());
    }
}
