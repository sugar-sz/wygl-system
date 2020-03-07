package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.UnitDto;
import com.sugar.wyglsystem.mbg.model.Unit;
import com.sugar.wyglsystem.service.UnitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/6 17:15
 * @description： 单元信息管理
 */
@RequestMapping("/unit")
@RestController
@Api(tags = "UnitController", description = "单元信息管理")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("/list")
    public CommonResult<CommonPage<Unit>> getUnitList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getBeanFactory();
        List<Unit> unitList = unitService.getUnitList(pageNum, pageSize);
        if (unitList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(unitList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/number/{number}")
    public CommonResult getUnitByNumber(@PathVariable Long number) {
        UnitDto unit = unitService.getUnitByNumber(number);
        if (unit != null) {
            return CommonResult.success(unit);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/height/{height}")
    public CommonResult<CommonPage<Unit>> getUnitByHeight(@PathVariable Integer height,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        System.out.println(pageSize);
        List<Unit> unitList = unitService.getUnitByHeight(height, pageNum, pageSize);
        if (unitList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(unitList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{number}")
    public CommonResult getUnitByBuildingNumber(@PathVariable Long number) {
        UnitDto unitDto = unitService.getUnitByBuildingNumber(number);
        if (unitDto != null) {
            return CommonResult.success(unitDto);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/delete/{id}")
    public CommonResult deleteUnit(@PathVariable Long id) {
        int count = unitService.deleteUnitById(id);
        if (count > 0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @PostMapping("/add")
    public CommonResult insertUnit(@RequestBody Unit unit) {
        System.out.println(unit);
        Unit rs = unitService.insertUniting(unit);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("插入失败");
    }

    @PostMapping("/update/{id}")
    public CommonResult updateUnit(@PathVariable Long id, @RequestBody Unit unit) {
        System.out.println(unit);
        int count = unitService.updateUnit(id, unit);
        if (count > 0) {
            return CommonResult.success(unit);
        }
        return CommonResult.failed("更新失败");
    }
}
