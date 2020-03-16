package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.RepairDto;
import com.sugar.wyglsystem.mbg.model.Repair;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 10:40
 * @description： 报修管理
 */
public interface RepairService {
    int insertRepair(Repair repair);
    RepairDto getRepairById(Long id);
    RepairDto getRepairByPeople(String name);
    RepairDto getRepairByPhone(String phone);

    List<Repair> getRepairByRoomId(Long roomId, Integer pageNum, Integer pageSize);
}
