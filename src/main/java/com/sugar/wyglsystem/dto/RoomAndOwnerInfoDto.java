package com.sugar.wyglsystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 13:23
 * @description：
 */
@Data
public class RoomAndOwnerInfoDto {
    @ApiModelProperty(value = "房屋id")
    private Long id;

    @ApiModelProperty(value = "房屋编号")
    private Long number;

    @ApiModelProperty(value = "楼层")
    private Integer height;

    @ApiModelProperty(value = "状态:1未售，0已售")
    private Integer status;

    @ApiModelProperty(value = "楼房编号")
    private Long buildingNumber;

    @ApiModelProperty(value = "单元编号")
    private Long unitNumber;

    @ApiModelProperty(value = "业主id")
    private Long ownerId;

    @ApiModelProperty(value = "业主姓名")
    private String name;

    @ApiModelProperty(value = "身份证")
    private String identity;
}
