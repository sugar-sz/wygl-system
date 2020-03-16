package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.mbg.model.Notice;
import com.sugar.wyglsystem.mbg.model.Owner;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 9:34
 * @description： 通知管理
 */
public interface NoticeService {
    List<Notice> getNoticeList(Integer pageNum, Integer pageSize);

    int deleteNotice(Long id);

    Notice getNoticeById(Long id);

    List<Notice> getNoticeByTitle(String title, Integer pageNum, Integer pageSize);

    List<Notice> getNoticeByType(Integer type, Integer pageNum, Integer pageSize);

    int updateNotice(Long id, Notice notice);

    Notice insertNotice(Notice notice);
}
