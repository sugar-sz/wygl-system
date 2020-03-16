package com.sugar.wyglsystem.dao;

import com.sugar.wyglsystem.dto.ParkSpaceAndOwnerDto;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 14:24
 * @description：
 */
public interface ParkSpaceDao {
    List<ParkSpaceAndOwnerDto> getParkSpaceAndOwnerInfo();
}
