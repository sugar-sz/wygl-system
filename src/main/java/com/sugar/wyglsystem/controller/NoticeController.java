package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.Notice;
import com.sugar.wyglsystem.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 9:48
 * @description：
 */
@RequestMapping("/notice")
@Api(tags = "NoticeController", description = "通知管理")
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    @ApiOperation("查询所有")
    public CommonResult<CommonPage<Notice>> getNoticeList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Notice> noticeList = noticeService.getNoticeList(pageNum, pageSize);
        if (noticeList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(noticeList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    public CommonResult getNoticeById(@PathVariable Long id) {
        Notice notice = noticeService.getNoticeById(id);
        if (notice != null) {
            return CommonResult.success(notice);
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/title")
    @ApiOperation("根据标题查询")
    public CommonResult<CommonPage<Notice>> getNoticeByTitle(@RequestParam String title,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Notice> noticeList = noticeService.getNoticeByTitle(title, pageNum, pageSize);
        if (noticeList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(noticeList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/type")
    @ApiOperation("根据类型查询")
    public CommonResult<CommonPage<Notice>> getNoticeByType(@RequestParam Integer type,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Notice> noticeList = noticeService.getNoticeByType(type, pageNum, pageSize);
        if (noticeList.size() > 0) {
            return CommonResult.success(CommonPage.resetPage(noticeList));
        }
        return CommonResult.failed("查询失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/add")
    @ApiOperation("插入notice")
    public CommonResult insertNotice(@RequestBody Notice notice) {
        Notice rs = noticeService.insertNotice(notice);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("插入失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/update/{id}")
    @ApiOperation("更新notice")
    public CommonResult updateNotice(@PathVariable Long id, @RequestBody Notice notice) {
        int count = noticeService.updateNotice(id, notice);
        if (count > 0) {
            return CommonResult.success(notice);
        }
        return CommonResult.failed("更新失败");
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @GetMapping("/delete/{id}")
    @ApiOperation("删除notice")
    public CommonResult deleteNotice(@PathVariable Long id) {
        int count = noticeService.deleteNotice(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("删除失败");
    }

    @GetMapping("/count")
    @ApiOperation("获取通知数量")
    public CommonResult getNoticeCount() {
        int count = noticeService.getNoticeCount();
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("查询失败");
    }
}
