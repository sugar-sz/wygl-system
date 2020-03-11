package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Car implements Serializable {
    @ApiModelProperty(value = "car id")
    private Long id;

    @ApiModelProperty(value = "车牌号")
    private String number;

    @ApiModelProperty(value = "车颜色")
    private String color;

    @ApiModelProperty(value = "车品牌")
    private String band;

    @ApiModelProperty(value = "0 家用小汽车 1 客车")
    private Integer type;

    @ApiModelProperty(value = "业主id")
    private Long ownerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", color=").append(color);
        sb.append(", band=").append(band);
        sb.append(", type=").append(type);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}