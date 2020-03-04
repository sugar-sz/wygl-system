package com.sugar.wyglsystem.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Owner implements Serializable {
    @ApiModelProperty(value = "业主id")
    private Long id;

    @ApiModelProperty(value = "业主姓名")
    private String name;

    @ApiModelProperty(value = "业主成员id")
    private Long memberId;

    @ApiModelProperty(value = "业主性别")
    private String sex;

    @ApiModelProperty(value = "业主年龄")
    private Integer age;

    @ApiModelProperty(value = "联系人手机号")
    private String phone;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "1 在用 0失效'")
    private Integer status;

    @ApiModelProperty(value = "身份证")
    private String identity;

    @ApiModelProperty(value = "创建员工")
    private String createPeople;

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", memberId=").append(memberId);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", phone=").append(phone);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", identity=").append(identity);
        sb.append(", createPeople=").append(createPeople);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}