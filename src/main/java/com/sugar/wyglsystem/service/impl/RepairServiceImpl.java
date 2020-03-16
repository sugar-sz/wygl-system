package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dto.RepairDto;
import com.sugar.wyglsystem.mbg.mapper.RepairMapper;
import com.sugar.wyglsystem.mbg.model.Repair;
import com.sugar.wyglsystem.mbg.model.RepairExample;
import com.sugar.wyglsystem.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 10:43
 * @description：
 */
@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;

    @Override
    public int insertRepair(Repair repair) {
        repair.setCreateTime(new Date());
        repair.setStatus(1);
        return repairMapper.insert(repair);
    }

    @Override
    public RepairDto getRepairById(Long id) {
        RepairDto repairDto = new RepairDto();
        List<Repair> repairList = new ArrayList<>();
        Repair repair = repairMapper.selectByPrimaryKey(id);
        if (repair != null) {
            repairList.add(repair);
            repairDto.setList(repairList);
            return repairDto;
        }
        return null;
    }

    @Override
    public RepairDto getRepairByPeople(String name) {
        RepairExample example = new RepairExample();
        example.createCriteria().andPeopleEqualTo(name);
        return getRepairInfo(example);
    }

    @Override
    public RepairDto getRepairByPhone(String phone) {
        RepairExample example = new RepairExample();
        example.createCriteria().andPhoneEqualTo(phone);
        return getRepairInfo(example);
    }

    @Override
    public List<Repair> getRepairByRoomId(Long roomId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RepairExample example = new RepairExample();
        example.createCriteria().andRoomIdEqualTo(roomId);
        List<Repair> repairList = repairMapper.selectByExample(example);
        if (repairList.size() > 0) {
            return repairList;
        }
        return null;
    }

    private RepairDto getRepairInfo(RepairExample example) {
        RepairDto repairDto = new RepairDto();
        List<Repair> repairList = repairMapper.selectByExample(example);
        if (repairList.size() > 0) {
            repairDto.setList(repairList);
            return repairDto;
        }
        return null;
    }
}
