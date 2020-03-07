package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.BuildingDto;
import com.sugar.wyglsystem.mbg.mapper.BuildingMapper;
import com.sugar.wyglsystem.mbg.model.Building;
import com.sugar.wyglsystem.mbg.model.BuildingExample;
import com.sugar.wyglsystem.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/5 19:14
 * @description：
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> getBuildingList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Building> buildingList = buildingMapper.selectByExample(new BuildingExample());
        if (buildingList.size() > 0) {
            return buildingList;
        }
        return null;
    }

    @Override
    public int deleteBuilding(Long id) {
        return buildingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BuildingDto getBuildingById(Long id) {
        BuildingDto buildingDto = new BuildingDto();
        List<Building> buildingList = new ArrayList<>();
        Building building = buildingMapper.selectByPrimaryKey(id);
        if (building != null) {
            buildingList.add(building);
            buildingDto.setList(buildingList);
            return buildingDto;
        }
        return null;
    }

    @Override
    public int updateBuilding(Long id, Building building) {
        building.setId(id);
        building.setCreateTime(building.getCreateTime());
        return buildingMapper.updateByPrimaryKey(building);
    }

    @Override
    public Building insertBuilding(Building building) {
        building.setCreateTime(new Date());
        buildingMapper.insert(building);
        return building;
    }

    @Override
    public BuildingDto getBuildingByName(String name) {
        BuildingDto buildingDto = new BuildingDto();
        BuildingExample example = new BuildingExample();
        example.createCriteria().andNameEqualTo(name);
        List<Building> buildingList = buildingMapper.selectByExample(example);
        if (buildingList.size() > 0) {
            buildingDto.setList(buildingList);
            return buildingDto;
        }
        return null;
    }

    @Override
    public BuildingDto getBuildingByNumber(Long number) {
        BuildingDto buildingDto = new BuildingDto();
        BuildingExample example = new BuildingExample();
        example.createCriteria().andNumberEqualTo(number);
        List<Building> buildingList = buildingMapper.selectByExample(example);
        if (buildingList.size() > 0) {
            buildingDto.setList(buildingList);
            return buildingDto;
        }
        return null;
    }
}
