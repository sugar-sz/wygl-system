package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.ParkAreaDto;
import com.sugar.wyglsystem.mbg.model.ParkArea;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 16:46
 * @description： 停车场信息
 */
public interface ParkAreaService {
    List<ParkArea> getParkAreaList(Integer pageNum, Integer pageSize);
    int deleteParkArea(Long id);
    ParkAreaDto getParkAreaById(Long id);
    ParkAreaDto getParkAreaByNumber(Long id);
    ParkAreaDto getParkAreaByType(Long id);
    int updateParkArea(Long id, ParkArea parkArea);
    ParkArea insertParkArea(ParkArea parkArea);
}
