package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.mbg.model.Member;
import com.sugar.wyglsystem.mbg.model.Owner;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/4 18:55
 * @description： 业主成员管理
 */
public interface MemberService {
    List<Member> getMemberList(Long id,Integer pageNum, Integer pageSize);
    int deleteMember(Long id);
    Member getMemberById(Long id);
    int updateMember(Long id, Member member);
    Member insertMember(Member member);
}
