package com.sugar.wyglsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/10 9:45
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemainingParkSpaceDto implements Serializable {
    private int total;
    private int remainingParkSpace;
    private Date date;
}
