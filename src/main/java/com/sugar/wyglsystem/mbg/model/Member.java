package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    @ApiModelProperty(value = "member")
    private Long id;

    @ApiModelProperty(value = "成员姓名")
    private String name;

    @ApiModelProperty(value = "成员联系方式")
    private String phone;

    @ApiModelProperty(value = "业主id")
    private Long ownerId;

    @ApiModelProperty(value = "成员年龄")
    private Integer age;

    @ApiModelProperty(value = "成员性别")
    private String sex;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "与业主的关系")
    private String relate;

    @ApiModelProperty(value = "身份证")
    private String identity;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRelate() {
        return relate;
    }

    public void setRelate(String relate) {
        this.relate = relate;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", status=").append(status);
        sb.append(", relate=").append(relate);
        sb.append(", identity=").append(identity);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}