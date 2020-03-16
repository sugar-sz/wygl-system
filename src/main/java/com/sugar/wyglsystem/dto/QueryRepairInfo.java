package com.sugar.wyglsystem.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 11:06
 * @description：
 */
@Data
public class QueryRepairInfo implements Serializable {
    private Long ownerId;
    private Long roomId;
    private Integer pageNum;
    private Integer pageSize;
}
