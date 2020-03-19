package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.Fee;
import com.sugar.wyglsystem.service.FeeConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ：lyj
 * @date ：Created in 2020/3/18 17:19
 * @description：
 */
@RequestMapping("/feeConfig")
@Api(tags = "FeeConfigController", description = "费用项管理")
@RestController
public class FeeConfigController {

    public static final Logger LOGGER = LoggerFactory.getLogger(FeeConfigController.class);
    @Autowired
    private FeeConfigService feeConfigService;

    @GetMapping("/list")
    @ApiOperation("查询所有")
    public CommonResult<CommonPage<Fee>> getFeeConfigList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Fee> feeList = feeConfigService.getFeeList(pageNum, pageSize);
        if (feeList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(feeList));
        }
        return CommonResult.failed("查询失败");
    }

    @PostMapping("/update/{id}")
    @ApiOperation("更新信息")
    public CommonResult updateFeeConfig(@PathVariable Long id, @RequestBody Fee fee) {
        int count = feeConfigService.update(id, fee);
        if (count > 0) {
            return CommonResult.success(fee);
        }
        return CommonResult.failed("更新失败");
    }

    @PostMapping("/add")
    @ApiOperation("新增信息")
    public CommonResult insertFeeConfig(@RequestBody Fee fee) {
        int count = feeConfigService.insert(fee);
        if (count > 0) {
            return CommonResult.success("成功");
        }
        return CommonResult.failed("插入失败");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("删除费用项")
    public CommonResult deleteFeeConfig(@PathVariable Long id) {
        int count = feeConfigService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("删除失败");
    }

    @GetMapping("/type")
    @ApiOperation("根据费用项类型查询")
    public CommonResult getFeeConfigByType(@RequestParam Integer type,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize) {
        List<Fee> feeList = feeConfigService.getFeeByFeeType(type, pageNum, pageSize);
        LOGGER.info(feeList.toString());
        if (feeList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(feeList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/item")
    @ApiOperation("根据费用项目查询")
    public CommonResult getFeeConfigByItem(@RequestParam String item) {
        Fee fee = feeConfigService.getFeeByFeeItem(item);
        LOGGER.info(fee.toString());
        if (fee != null) {
            return CommonResult.success(fee);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/flag")
    @ApiOperation("根据标识查询")
    public CommonResult getFeeConfigByFlag(@RequestParam Integer flag,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Fee> feeList = feeConfigService.getFeeByFeeFlag(flag, pageNum, pageSize);
        LOGGER.info(feeList.toString());
        if (feeList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(feeList));
        }
        return CommonResult.failed("查询失败");
    }

}
