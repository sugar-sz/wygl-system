package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.ParkAreaDto;
import com.sugar.wyglsystem.mbg.mapper.ParkAreaMapper;
import com.sugar.wyglsystem.mbg.model.ParkArea;
import com.sugar.wyglsystem.mbg.model.ParkAreaExample;
import com.sugar.wyglsystem.service.ParkAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 16:51
 * @description：
 */
@Service
public class ParkAreaServiceImpl implements ParkAreaService {
    @Autowired
    private ParkAreaMapper parkAreaMapper;

    @Override
    public List<ParkArea> getParkAreaList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ParkArea> parkAreaList = parkAreaMapper.selectByExample(new ParkAreaExample());
        if (parkAreaList.size() > 0) {
            return parkAreaList;
        }
        return null;
    }

    @Override
    public int deleteParkArea(Long id) {
        return parkAreaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ParkAreaDto getParkAreaById(Long id) {
        ParkAreaDto parkAreaDto = new ParkAreaDto();
        List<ParkArea> parkAreaList = new ArrayList<>();
        ParkArea parkArea = parkAreaMapper.selectByPrimaryKey(id);
        if (parkArea != null) {
            parkAreaList.add(parkArea);
            parkAreaDto.setList(parkAreaList);
            return parkAreaDto;
        }
        return null;
    }

    @Override
    public ParkAreaDto getParkAreaByNumber(Long id) {
        ParkAreaDto parkAreaDto = new ParkAreaDto();
        ParkAreaExample example = new ParkAreaExample();
        example.createCriteria().andNumberEqualTo(id);
        List<ParkArea> parkAreaList = parkAreaMapper.selectByExample(example);
        if (parkAreaList.size() > 0) {
            parkAreaDto.setList(parkAreaList);
            return parkAreaDto;
        }
        return null;
    }

    @Override
    public ParkAreaDto getParkAreaByType(Long id) {
        ParkAreaDto parkAreaDto = new ParkAreaDto();
        ParkAreaExample example = new ParkAreaExample();
        example.createCriteria().andTypeEqualTo(id);
        List<ParkArea> parkAreaList = parkAreaMapper.selectByExample(example);
        if (parkAreaList.size() > 0) {
            parkAreaDto.setList(parkAreaList);
            return parkAreaDto;
        }
        return null;
    }

    @Override
    public int updateParkArea(Long id, ParkArea parkArea) {
        parkArea.setId(id);
        return parkAreaMapper.updateByPrimaryKey(parkArea);
    }

    @Override
    public ParkArea insertParkArea(ParkArea parkArea) {
        parkArea.setCreateTime(new Date());
        parkAreaMapper.insert(parkArea);
        return parkArea;
    }
}
