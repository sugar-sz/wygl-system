package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Repair;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 10:42
 * @description：
 */
@Data
public class RepairDto implements Serializable {
    private List<Repair> list;
}
