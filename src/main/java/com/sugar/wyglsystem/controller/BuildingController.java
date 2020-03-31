package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.BuildingDto;
import com.sugar.wyglsystem.mbg.model.Building;
import com.sugar.wyglsystem.service.BuildingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/5 19:20
 * @description： 楼房信息管理
 */
@RequestMapping("/building")
@Api(tags = "BuildingController", description = "楼房信息管理")
@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/list")
    public CommonResult<CommonPage<Building>> getBuildingList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(pageSize);
        List<Building> buildingList = buildingService.getBuildingList(pageNum, pageSize);
        if (buildingList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(buildingList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{id}")
    public CommonResult getBuildingById(@PathVariable String id) {
        System.out.println(id);
        BuildingDto building = buildingService.getBuildingById(Long.valueOf(id));
        if (building != null) {
            return CommonResult.success(building);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/number/{number}")
    public CommonResult getBuildingByNumber(@PathVariable String number) {
        System.out.println(number);
        BuildingDto buildingDto = buildingService.getBuildingByNumber(Long.valueOf(number));
        if (buildingDto != null) {
            return CommonResult.success(buildingDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/")
    public CommonResult getBuildingByName(@RequestParam String name) {
        System.out.println(name);
        BuildingDto building = buildingService.getBuildingByName(name);
        if (building != null) {
            return CommonResult.success(building);
        }
        return CommonResult.failed("查询失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/add")
    public CommonResult insertBuilding(@RequestBody Building building) {
        Building rs = buildingService.insertBuilding(building);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("插入失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/update/{id}")
    public CommonResult updateBuilding(@PathVariable Long id, @RequestBody Building building) {
        int count = buildingService.updateBuilding(id, building);
        if (count > 0) {
            return CommonResult.success(building);
        }
        return CommonResult.failed("更新失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @GetMapping("/delete/{id}")
    public CommonResult deleteBuilding(@PathVariable Long id) {
        int count = buildingService.deleteBuilding(id);
        if (count > 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("删除失败");
    }

}
