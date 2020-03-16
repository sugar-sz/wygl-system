package com.sugar.wyglsystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 14:21
 * @description：
 */
@Data
public class ParkSpaceAndOwnerDto implements Serializable {
    @ApiModelProperty(value = "停车位id")
    private Long id;

    @ApiModelProperty(value = "车位编号")
    private Long number;

    @ApiModelProperty(value = "停车场编号")
    private Long parkAreaNumber;

    @ApiModelProperty(value = "业主id")
    private Long ownerId;

    @ApiModelProperty(value = "车牌号")
    private String carNumber;

    @ApiModelProperty(value = "业主姓名")
    private String name;

    @ApiModelProperty(value = "身份证")
    private String identity;
}
