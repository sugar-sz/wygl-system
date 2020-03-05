package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.BuildingDto;
import com.sugar.wyglsystem.mbg.model.Building;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/5 19:10
 * @description： 楼房信息
 */
public interface BuildingService {
    List<Building> getBuildingList(Integer pageNum, Integer pageSize);

    int deleteBuilding(Long id);

    BuildingDto getBuildingById(Long id);

    int updateBuilding(Long id, Building building);

    Building insertBuilding(Building building);

    BuildingDto getBuildingByName(String name);

    BuildingDto getBuildingByNumber(Long number);
}
