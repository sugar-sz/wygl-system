package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.OwnerDto;
import com.sugar.wyglsystem.mbg.model.Owner;
import com.sugar.wyglsystem.service.OwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/4 10:39
 * @description： 业主信息管理
 */
@RequestMapping("/owner")
@Api(tags = "OwnerController", description = "业主信息管理")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    @ApiOperation("获得所有业主")
    public CommonResult<CommonPage<Owner>> getOwnerList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        List<Owner> ownerList = ownerService.getOwnerList(pageNum, pageSize);
        return CommonResult.success(CommonPage.resetPage(ownerList));
    }

    @PostMapping("/add")
    @ApiOperation("增加业主信息")
    public CommonResult<Owner> insertOwner(@RequestBody Owner owner) {
        Owner insertOwner = ownerService.insertOwner(owner);
        if (insertOwner != null) {
            return CommonResult.success(owner);
        }
        return CommonResult.failed("增加失败");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("删除业主信息")
    public CommonResult deleteOwner(@PathVariable Long id) {
        int count = ownerService.deleteOwner(id);
        if (count == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("操作失败");
    }

    @PostMapping("/update/{id}")
    @ApiOperation("更新业主信息")
    public CommonResult updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
        int count = ownerService.updateOwner(id, owner);
        if (count == 1) {
            return CommonResult.success(owner);
        }
        return CommonResult.failed("更新失败");
    }

    @GetMapping("/")
    @ApiOperation("根据姓名查找业主")
    public CommonResult<CommonPage<Owner>> selectOwnerByName(@RequestParam String name,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(name);
        List<Owner> ownerList = ownerService.getOwnerByName(name, pageNum, pageSize);
        if (!ownerList.isEmpty()) {
            return CommonResult.success(CommonPage.resetPage(ownerList));
        }
        return CommonResult.failed("业主不存在");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询业主")
    public CommonResult selectOwnerById(@PathVariable("id") Long id) {
        OwnerDto ownerDto = ownerService.getOwnerById(id);
        if (ownerDto != null) {
            return CommonResult.success(ownerDto);
        }
        return null;
    }
}
