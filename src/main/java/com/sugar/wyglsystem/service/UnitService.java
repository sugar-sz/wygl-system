package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.UnitDto;
import com.sugar.wyglsystem.mbg.model.Unit;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/6 15:21
 * @description： 单元信息管理
 */
public interface UnitService {
    List<Unit> getUnitList(Integer pageNum, Integer pageSize);

    int deleteUnitById(Long id);

    int updateUnit(Long id, Unit unit);

    Unit insertUniting(Unit unit);

    UnitDto getUnitByNumber(Long number);

    List<Unit> getUnitByHeight(Integer height, Integer pageNum, Integer pageSize);

    UnitDto getUnitByBuildingNumber(Long number);
}
