package com.sugar.wyglsystem.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 11:14
 * @description： 用户登录数据传输对象
 */
@Data
public class AdminLoginParam implements Serializable {
    private String username;
    private String password;
    private static final long serialVersionUID = 1L;
}
