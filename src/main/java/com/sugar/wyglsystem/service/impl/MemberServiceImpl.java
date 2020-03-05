package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.mbg.mapper.MemberMapper;
import com.sugar.wyglsystem.mbg.model.Member;
import com.sugar.wyglsystem.mbg.model.MemberExample;
import com.sugar.wyglsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/4 18:57
 * @description：
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> getMemberList(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        MemberExample example = new MemberExample();
        example.createCriteria().andOwnerIdEqualTo(id);
        List<Member> memberList = memberMapper.selectByExample(example);
        if (memberList.size() > 0) {
            return memberList;
        }
        return null;
    }

    @Override
    public int deleteMember(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Member getMemberById(Long id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        if (member != null) {
            return member;
        }
        return null;
    }

    @Override
    public int updateMember(Long id, Member member) {
        member.setId(id);
        return memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public Member insertMember(Member member) {
        member.setCreateTime(new Date());
        member.setStatus(1);
        memberMapper.insert(member);
        return member;
    }
}
