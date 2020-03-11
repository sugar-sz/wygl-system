package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.ParkSpace;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 18:59
 * @description：
 */
@Data
public class ParkSpaceDto implements Serializable {
    private List<ParkSpace> list;
}
