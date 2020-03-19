package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.FeeDetailsDto;
import com.sugar.wyglsystem.mbg.model.FeeDetails;
import com.sugar.wyglsystem.service.FeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 11:42
 * @description：
 */
@RequestMapping("/feeDetails")
@RestController
public class FeeDetailsController {

    @Autowired
    private FeeDetailsService feeDetailsService;

    @GetMapping("/list")
    public CommonResult<CommonPage<FeeDetailsDto>> getFeeDetailsList(@RequestParam Long roomId,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<FeeDetailsDto> feeDetailsList = feeDetailsService.getFeeDetailsList(roomId, pageNum, pageSize);
        if(feeDetailsList.size()>0){
            return CommonResult.success(CommonPage.resetPage(feeDetailsList));
        }
        return CommonResult.failed("查询失败");
    }

    @PostMapping("/add")
    public CommonResult inertFeeDetails(@RequestBody FeeDetails feeDetails){
        int count = feeDetailsService.insert(feeDetails);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("插入失败");
    }

}
