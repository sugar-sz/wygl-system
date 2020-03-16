package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.ParkSpaceAndOwnerDto;
import com.sugar.wyglsystem.dto.ParkSpaceDto;
import com.sugar.wyglsystem.dto.RemainingParkSpaceDto;
import com.sugar.wyglsystem.mbg.model.ParkSpace;
import com.sugar.wyglsystem.service.ParkSpaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/9 19:09
 * @description：
 */
@RequestMapping("/parkSpace")
@Api(tags = "ParkSpaceController", description = "车位信息管理")
@RestController
public class ParkSpaceController {
    @Autowired
    private ParkSpaceService parkSpaceService;

    @GetMapping("/list")
    @ApiOperation(value = "查询所有车位")
    public CommonResult<CommonPage<ParkSpace>> getParkSpaceList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(pageSize);
        List<ParkSpace> parkSpaceList = parkSpaceService.getParkSpaceList(pageNum, pageSize);
        if (parkSpaceList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(parkSpaceList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询车位")
    public CommonResult getParkSpaceById(@PathVariable Long id) {
        ParkSpaceDto parkSpaceDto = parkSpaceService.getParkSpaceById(id);
        if (parkSpaceDto != null) {
            return CommonResult.success(parkSpaceDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/number/{number}")
    @ApiOperation("根据number查询停车场")
    public CommonResult getParkSpaceByNumber(@PathVariable Long number) {
        ParkSpaceDto parkSpaceDto = parkSpaceService.getParkSpaceByNumber(number);
        if (parkSpaceDto != null) {
            return CommonResult.success(parkSpaceDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/status/{status}")
    @ApiOperation("根据status查询停车场")
    public CommonResult getParkSpaceByStatus(@PathVariable Integer status) {
        ParkSpaceDto parkSpaceDto = parkSpaceService.getParkSpaceByStatus(status);
        if (parkSpaceDto != null) {
            return CommonResult.success(parkSpaceDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/parkArea/{number}")
    @ApiOperation("根据status查询停车场")
    public CommonResult getParkSpaceByStatus(@PathVariable Long number) {
        ParkSpaceDto parkSpaceDto = parkSpaceService.getParkSpaceByParkAreaNumber(number);
        if (parkSpaceDto != null) {
            return CommonResult.success(parkSpaceDto);
        }
        return CommonResult.failed("查询失败");
    }

    @PostMapping("/update/{id}")
    @ApiOperation("更新停车场信息")
    public CommonResult updateParkSpace(@PathVariable Long id, @RequestBody ParkSpace parkSpace) {
        int count = parkSpaceService.updateParkSpace(id, parkSpace);
        if (count > 0) {
            return CommonResult.success(parkSpace);
        }
        return CommonResult.failed("更新失败");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("根据id删除")
    public CommonResult deleteParkSpace(@PathVariable Long id) {
        int count = parkSpaceService.deleteParkSpace(id);
        if (count > 0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @PostMapping("/add")
    @ApiOperation("新增停车场")
    public CommonResult insertParkSpace(@RequestBody ParkSpace parkSpace) {
        ParkSpace rs = parkSpaceService.insertParkSpace(parkSpace);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("新增失败");
    }

    @GetMapping("/count")
    @ApiOperation("剩余车位数")
    public CommonResult countParkSpace() {
        int total = parkSpaceService.countTotal();
        int remaining = parkSpaceService.countRemainingParkSpace();
        return CommonResult.success(new RemainingParkSpaceDto(total, remaining, new Date()));
    }

    @GetMapping("/parkingSpaceCreateFee")
    @ApiOperation("获取车位和业主信息")
    public CommonResult getParkSpaceAndOwnerInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<ParkSpaceAndOwnerDto> parkSpaceAndOwnerDtoList = parkSpaceService.getParkSpaceAndOwnerInfo(pageNum, pageSize);
        if (parkSpaceAndOwnerDtoList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(parkSpaceAndOwnerDtoList));
        }
        return CommonResult.failed("查询失败");
    }
}
