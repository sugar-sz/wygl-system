package com.sugar.wyglsystem.dto;

import lombok.Data;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 11:14
 * @description： 用户登录数据传输对象
 */
@Data
public class AdminLoginParam {
    private String username;
    private String password;
}
