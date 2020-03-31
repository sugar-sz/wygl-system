package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.RepairDto;
import com.sugar.wyglsystem.mbg.model.Repair;
import com.sugar.wyglsystem.service.RepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/13 10:53
 * @description： 报修管理
 */
@RequestMapping("/repair")
@Api(tags = "RepairController", description = "报修管理")
@RestController
public class RepairController {
    @Autowired
    private RepairService repairService;

    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    public CommonResult getRepairById(@PathVariable Long id) {
        RepairDto repairDto = repairService.getRepairById(id);
        if (repairDto != null) {
            return CommonResult.success(repairDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/phone")
    @ApiOperation("根据联系方式查询")
    public CommonResult getRepairByPhone(@RequestParam String phone) {
        RepairDto repairDto = repairService.getRepairByPhone(phone);
        if (repairDto != null) {
            return CommonResult.success(repairDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/people")
    @ApiOperation("根据报修人查询")
    public CommonResult getRepairByPeople(@RequestParam String people) {
        RepairDto repairDto = repairService.getRepairByPeople(people);
        if (repairDto != null) {
            return CommonResult.success(repairDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/list")
    @ApiOperation("查询房屋所有报修信息")
    public CommonResult<CommonPage<Repair>> getRepairByRoomId(@RequestParam("roomId") Long roomId,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(roomId);
        List<Repair> repairList = repairService.getRepairByRoomId(roomId, pageNum, pageSize);
        if (repairList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(repairList));
        }
        return CommonResult.failed("查询失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/add")
    @ApiOperation("登记保修信息")
    public CommonResult insertRepair(@RequestBody Repair repair) {
        System.out.println(repair);
        int count = repairService.insertRepair(repair);
        if (count > 0) {
            return CommonResult.success(repair);
        }
        return CommonResult.failed("插入失败");
    }
}
