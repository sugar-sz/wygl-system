package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.ParkAreaDto;
import com.sugar.wyglsystem.mbg.model.ParkArea;
import com.sugar.wyglsystem.service.ParkAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 17:00
 * @description：
 */
@RequestMapping("/parkArea")
@Api(tags = "ParkAreaController", description = "停车场信息管理")
@RestController
public class ParkAreaController {
    @Autowired
    private ParkAreaService parkAreaService;

    @GetMapping("/list")
    @ApiOperation(value = "查询所有停车场")
    public CommonResult<CommonPage<ParkArea>> getParkAreaList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "400") Integer pageSize) {
        System.out.println(pageSize);
        List<ParkArea> parkAreaList = parkAreaService.getParkAreaList(pageNum, pageSize);
        if (parkAreaList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(parkAreaList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询停车场")
    public CommonResult getParkAreaById(@PathVariable Long id) {
        ParkAreaDto parkAreaDto = parkAreaService.getParkAreaById(id);
        if (parkAreaDto != null) {
            return CommonResult.success(parkAreaDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/number/{number}")
    @ApiOperation("根据number查询停车场")
    public CommonResult getParkAreaByNumber(@PathVariable Long number) {
        ParkAreaDto parkAreaDto = parkAreaService.getParkAreaByNumber(number);
        if (parkAreaDto != null) {
            return CommonResult.success(parkAreaDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/type/{type}")
    @ApiOperation("根据type查询停车场")
    public CommonResult getParkAreaByType(@PathVariable Long type) {
        ParkAreaDto parkAreaDto = parkAreaService.getParkAreaByType(type);
        if (parkAreaDto != null) {
            return CommonResult.success(parkAreaDto);
        }
        return CommonResult.failed("查询失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/update/{id}")
    @ApiOperation("更新停车场信息")
    public CommonResult updateParkArea(@PathVariable Long id, @RequestBody ParkArea parkArea) {
        int count = parkAreaService.updateParkArea(id, parkArea);
        if (count > 0) {
            return CommonResult.success(parkArea);
        }
        return CommonResult.failed("更新失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @GetMapping("/delete/{id}")
    @ApiOperation("根据id删除")
    public CommonResult deleteParkArea(@PathVariable Long id) {
        int count = parkAreaService.deleteParkArea(id);
        if (count > 0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/add")
    @ApiOperation("新增停车场")
    public CommonResult insertParkArea(@RequestBody ParkArea parkArea) {
        ParkArea rs = parkAreaService.insertParkArea(parkArea);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("新增失败");
    }


}
