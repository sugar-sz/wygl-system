package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {
    @ApiModelProperty(value = "报修id")
    private Long id;

    @ApiModelProperty(value = "0 卧室报修，1 客厅报修 2 管道报修")
    private Integer type;

    @ApiModelProperty(value = "报修人")
    private String people;

    @ApiModelProperty(value = "联系方式")
    private String phone;

    @ApiModelProperty(value = "预约时间")
    private Date time;

    @ApiModelProperty(value = "0 处理完成 1 处理中")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "业主id")
    private Long ownerId;

    @ApiModelProperty(value = "房屋id")
    private Long roomId;

    @ApiModelProperty(value = "报修内容")
    private String content;

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

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", people=").append(people);
        sb.append(", phone=").append(phone);
        sb.append(", time=").append(time);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", roomId=").append(roomId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}