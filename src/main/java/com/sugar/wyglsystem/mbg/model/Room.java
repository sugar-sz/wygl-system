package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Room implements Serializable {
    @ApiModelProperty(value = "房屋id")
    private Long id;

    @ApiModelProperty(value = "房屋编号")
    private Long number;

    @ApiModelProperty(value = "楼层")
    private Integer height;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal area;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "状态:1未售，0已售")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "楼房编号")
    private Long buildingNumber;

    @ApiModelProperty(value = "单元编号")
    private Long unitNumber;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Long buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Long getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Long unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", height=").append(height);
        sb.append(", area=").append(area);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", buildingNumber=").append(buildingNumber);
        sb.append(", unitNumber=").append(unitNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}