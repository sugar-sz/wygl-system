package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonPage;
import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.Member;
import com.sugar.wyglsystem.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/4 18:59
 * @description：
 */
@RequestMapping("/member")
@RestController
@Api(tags = "MemberController", description = "业主成员信息")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    @ApiOperation(value = "查询所有业主成员")
    public CommonResult<CommonPage<Member>> getMemberList(@RequestParam("id") Long id,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Member> memberList = memberService.getMemberList(id, pageNum, pageSize);
        if (!memberList.isEmpty()) {
            return CommonResult.success(CommonPage.resetPage(memberList));
        }
        return CommonResult.failed("查询失败");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public CommonResult getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        if (member != null) {
            return CommonResult.success(member);
        }
        return CommonResult.failed("查询失败");
    }

    @PostMapping("/update/{id}")
    @ApiOperation(value = "更新成员信息")
    public CommonResult updateMember(@PathVariable Long id, @RequestBody Member member) {
        int count = memberService.updateMember(id, member);
        if (count > 0) {
            return CommonResult.success(member);
        }
        return CommonResult.failed("更新失败");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除")
    public CommonResult deleteMember(@PathVariable Long id) {
        int count = memberService.deleteMember(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return null;
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增成员")
    public CommonResult insertMember(@RequestBody Member member) {
        System.out.println(member);
        Member rs = memberService.insertMember(member);
        if (rs != null) {
            return CommonResult.success(rs);
        }
        return CommonResult.failed("插入失败");
    }

}
