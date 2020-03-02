package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.AdminLoginParam;
import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import com.sugar.wyglsystem.service.impl.WyglAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 10:47
 * @description： admin 用户
 */
@Api(tags = "AdminController", description = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class WyglAdminController {
    @Autowired
    private WyglAdminService adminService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public CommonResult login(@RequestBody AdminLoginParam loginParam) {
        WyglAdmin result = adminService.login(loginParam.getUsername(), loginParam.getPassword());
        if (result == null) {
            return CommonResult.failed("用户名或密码错误,登陆失败");
        }
        return CommonResult.success(result);
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户登录")
    public CommonResult register(@RequestBody WyglAdmin wyglAdmin) {
        WyglAdmin admin = adminService.register(wyglAdmin);
        if (admin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(admin);
    }
}
