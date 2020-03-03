package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Community implements Serializable {
    @ApiModelProperty(value = "小区ID")
    private Long communityId;

    @ApiModelProperty(value = "小区名称")
    private String name;

    @ApiModelProperty(value = "小区地址")
    private String communityAddress;

    @ApiModelProperty(value = "月份")
    private String month;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "数据状态，添加ADD，修改MOD 删除DEL")
    private String operate;

    @ApiModelProperty(value = "管理员id")
    private Long adminId;

    @ApiModelProperty(value = "小区联系方式")
    private String phone;

    private static final long serialVersionUID = 1L;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", communityId=").append(communityId);
        sb.append(", name=").append(name);
        sb.append(", communityAddress=").append(communityAddress);
        sb.append(", month=").append(month);
        sb.append(", createTime=").append(createTime);
        sb.append(", operate=").append(operate);
        sb.append(", adminId=").append(adminId);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}