package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.Community;
import com.sugar.wyglsystem.service.CommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/3 9:29
 * @description： 小区信息管理
 */
@Api(tags = "CommunityController", description = "小区信息管理")
@RequestMapping("/community")
@RestController
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping("/list")
    @ApiOperation(value = "根据adminId查询所有小区信息并分页")
    public CommonResult<CommonPage<Community>> getCommunityList(@RequestParam("id") long id,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Community> communityList = communityService.getCommunityList(id, pageNum, pageSize);
        CommonResult<CommonPage<Community>> success = CommonResult.success(CommonPage.resetPage(communityList));
        return success;
    }

    @GetMapping("/")
    @ApiOperation(value = "根据姓名查询小区信息")
    public CommonResult<CommonPage<Community>> getCommunityByName(@RequestParam("name") String name,
                                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Community> communityList = communityService.getCommunityByName(name, pageNum, pageSize);
        return CommonResult.success(CommonPage.resetPage(communityList));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询小区信息")
    public CommonResult<Community> getCommunityById(@PathVariable Long id) {
        Community community = communityService.getCommunityById(id);
        if (community == null) {
            return CommonResult.failed(null);
        }
        return CommonResult.success(community);
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除小区信息")
    public CommonResult deleteCommunity(@PathVariable Long id) {
        int count = communityService.deleteCommunity(id);
        if (count == 1) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("操作失败");
    }

    @PostMapping("/deleteList")
    @ApiOperation(value = "根据List删除所有")
    public CommonResult deleteListCommunity(@RequestParam("ids") List<Long> idList) {
        System.out.println(idList);
        int count = communityService.deleteListCommunity(idList);
        if (count > 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("删除失败");
    }

    @PostMapping("/add")
    @ApiOperation(value = "增加小区信息")
    public CommonResult<Community> insertCommunity(@RequestBody Community community) {
        Community rtCommunity = communityService.insertCommunity(community);
        if (rtCommunity != null) {
            return CommonResult.success(rtCommunity);
        }
        return CommonResult.failed("操作失败");
    }

    @PostMapping(value = "/update/{id}", produces = "application/json")
    @ApiOperation(value = "更新小区信息")
    public CommonResult updateCommunity(@PathVariable long id, @RequestBody Community community) {
        System.out.println(community);
        int count = communityService.updateCommunity(id, community);
        if (count == 1) {
            return CommonResult.success(community);
        }
        return CommonResult.failed("更新失败");
    }

}
