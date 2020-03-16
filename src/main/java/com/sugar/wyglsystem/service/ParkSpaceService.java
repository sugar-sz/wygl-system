package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.ParkSpaceAndOwnerDto;
import com.sugar.wyglsystem.dto.ParkSpaceDto;
import com.sugar.wyglsystem.mbg.model.ParkSpace;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 18:51
 * @description： 车位信息
 */
public interface ParkSpaceService {
    List<ParkSpace> getParkSpaceList(Integer pageNum, Integer pageSize);
    int deleteParkSpace(Long id);
    ParkSpaceDto getParkSpaceById(Long id);
    ParkSpaceDto getParkSpaceByNumber(Long id);
    ParkSpaceDto getParkSpaceByStatus(Integer id);
    int updateParkSpace(Long id, ParkSpace ParkSpace);
    ParkSpace insertParkSpace(ParkSpace parkSpace);
    ParkSpaceDto getParkSpaceByParkAreaNumber(Long number);
    int countRemainingParkSpace();
    int countTotal();

    List<ParkSpaceAndOwnerDto> getParkSpaceAndOwnerInfo(Integer pageNum, Integer pageSize);
}
