package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable {
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

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "投诉状态")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getComplaintPeople() {
        return complaintPeople;
    }

    public void setComplaintPeople(String complaintPeople) {
        this.complaintPeople = complaintPeople;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", roomId=").append(roomId);
        sb.append(", complaintPeople=").append(complaintPeople);
        sb.append(", phone=").append(phone);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}