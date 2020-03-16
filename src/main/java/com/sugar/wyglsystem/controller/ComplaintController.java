package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.dto.ComplaintAndRoomInfoDto;
import com.sugar.wyglsystem.mbg.model.Complaint;
import com.sugar.wyglsystem.service.ComplaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 13:19
 * @description：
 */
@RequestMapping("/complaint")
@Api(tags = "ComplaintController", description = "投诉信息管理")
@RestController
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/list")
    @ApiOperation(value = "查询所有投诉信息")
    public CommonResult<CommonPage<ComplaintAndRoomInfoDto>> getComplaintList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                              @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<ComplaintAndRoomInfoDto> complaintList = complaintService.getComplaintList(pageNum, pageSize);
        if (complaintList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(complaintList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    public CommonResult<ComplaintAndRoomInfoDto> getComplaintById(@PathVariable Long id) {
        ComplaintAndRoomInfoDto complaint = complaintService.getComplaintById(id);
        if (complaint != null) {
            return CommonResult.success(complaint);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/name")
    @ApiOperation("根据投诉人查询")
    public CommonResult<CommonPage<ComplaintAndRoomInfoDto>> getComplaintByName(String name,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<ComplaintAndRoomInfoDto> complaintList = complaintService.getComplaintByName(name, pageNum, pageSize);
        if (complaintList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(complaintList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/type")
    @ApiOperation("根据投诉人查询")
    public CommonResult<CommonPage<ComplaintAndRoomInfoDto>> getComplaintByType(Integer type,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<ComplaintAndRoomInfoDto> complaintList = complaintService.getComplaintByType(type, pageNum, pageSize);
        if (complaintList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(complaintList));
        }
        return CommonResult.failed("查询失败");
    }

    @PostMapping("/add")
    @ApiOperation("新增complaint")
    public CommonResult insertComplaint(@RequestBody Complaint complaint) {
        Complaint rs = complaintService.insertComplaint(complaint);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("插入失败");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("根据id删除")
    public CommonResult deleteComplaint(@PathVariable Long id) {
        int count = complaintService.deleteComplaint(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("删除失败");
    }

    @PostMapping("/update/{id}")
    @ApiOperation("更新complaint")
    public CommonResult updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
        int count = complaintService.updateComplaint(id, complaint);
        if (count > 0) {
            return CommonResult.success(complaint);
        }
        return CommonResult.failed("更新失败");
    }
}
