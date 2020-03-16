package com.sugar.wyglsystem.dao;

import com.sugar.wyglsystem.dto.RoomAndOwnerInfoDto;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 13:50
 * @description： 自定义roomDao
 */
public interface RoomDao {
    List<RoomAndOwnerInfoDto> getRoomAndOwnerInfo();
}
