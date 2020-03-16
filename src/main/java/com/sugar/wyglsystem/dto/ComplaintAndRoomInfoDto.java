package com.sugar.wyglsystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 13:31
 * @description：
 */
@Data
public class ComplaintAndRoomInfoDto {
    @ApiModelProperty(value = "投诉id")
    private Long id;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "房屋id")
    private Long roomId;

    @ApiModelProperty(value = "投诉人")
    private String complaintPeople;

    @ApiModelProperty(value = "投诉电话")
    private String phone;

    @ApiModelProperty(value = "投诉内容")
    private String content;

    private Date createTime;

    @ApiModelProperty(value = "投诉状态")
    private Integer status;

    private Long buildingNumber;

    private Long unitNumber;
}
