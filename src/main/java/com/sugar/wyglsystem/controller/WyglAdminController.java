package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import com.sugar.wyglsystem.service.WyglAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 10:47
 * @description： admin 用户
 */
@Api(tags = "AdminController", description = "后台用户管理")
@RestController
public class WyglAdminController {
    @Autowired
    private WyglAdminService adminService;

    @GetMapping("/login")
    public CommonResult login() {
        return CommonResult.failed("尚未登录，请登录!");
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

    @GetMapping("/info")
    @ApiOperation(value = "根据id查询")
    public CommonResult getAdminById(@RequestParam Long id) {
        System.out.println(id);
        WyglAdmin admin = adminService.getAdminById(id);
        if (admin != null) {
            return CommonResult.success(admin);
        }
        return CommonResult.failed("查询失败");
    }
}
