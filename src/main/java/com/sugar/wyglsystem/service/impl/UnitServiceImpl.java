package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.UnitDto;
import com.sugar.wyglsystem.mbg.mapper.UnitMapper;
import com.sugar.wyglsystem.mbg.model.Unit;
import com.sugar.wyglsystem.mbg.model.UnitExample;
import com.sugar.wyglsystem.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/6 15:27
 * @description：
 */
@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public List<Unit> getUnitList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Unit> unitList = unitMapper.selectByExample(new UnitExample());
        if (unitList.size() > 0) {
            return unitList;
        }
        return null;
    }

    @Override
    public int deleteUnitById(Long id) {
        return unitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUnit(Long id, Unit unit) {
        unit.setId(id);
        return unitMapper.updateByPrimaryKey(unit);
    }

    @Override
    public Unit insertUniting(Unit unit) {
        unit.setCreateTime(new Date());
        unitMapper.insert(unit);
        return unit;
    }

    @Override
    public UnitDto getUnitByNumber(Long number) {
        UnitDto unitDto = new UnitDto();
        UnitExample example = new UnitExample();
        example.createCriteria().andNumberEqualTo(number);
        List<Unit> unitList = unitMapper.selectByExample(example);
        if (unitList.size() > 0) {
            unitDto.setList(unitList);
            return unitDto;
        }
        return null;
    }

    @Override
    public List<Unit> getUnitByHeight(Integer height, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UnitExample example = new UnitExample();
        example.createCriteria().andHeightEqualTo(height);
        List<Unit> unitList = unitMapper.selectByExample(example);
        if (unitList.size() > 0) {
            return unitList;
        }
        return null;
    }

    @Override
    public UnitDto getUnitByBuildingNumber(Long number) {
        UnitDto unitDto = new UnitDto();
        UnitExample example = new UnitExample();
        example.createCriteria().andBuildingNumberEqualTo(number);
        List<Unit> unitList = unitMapper.selectByExample(example);
        if (unitList.size() > 0) {
            unitDto.setList(unitList);
            return unitDto;
        }
        return null;
    }
}
