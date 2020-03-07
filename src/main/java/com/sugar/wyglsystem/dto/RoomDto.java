package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Room;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/7 14:53
 * @description：
 */
@Data
public class RoomDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Room> list;
}
