package com.sugar.wyglsystem.dao;

import com.sugar.wyglsystem.dto.ComplaintAndRoomInfoDto;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 13:30
 * @description：
 */
public interface ComplaintDao {
    List<ComplaintAndRoomInfoDto> getComplaintInfo();

    ComplaintAndRoomInfoDto getComplaintById(Long id);

    List<ComplaintAndRoomInfoDto> getComplaintByName(String name);

    List<ComplaintAndRoomInfoDto> getComplaintByType(Integer type);
}
