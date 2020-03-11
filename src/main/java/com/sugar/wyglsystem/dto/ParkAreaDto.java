package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.ParkArea;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 16:49
 * @description：
 */
@Data
public class ParkAreaDto implements Serializable {
    List<ParkArea> list;
}
