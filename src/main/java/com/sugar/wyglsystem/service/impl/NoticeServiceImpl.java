package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.mbg.mapper.NoticeMapper;
import com.sugar.wyglsystem.mbg.model.Notice;
import com.sugar.wyglsystem.mbg.model.NoticeExample;
import com.sugar.wyglsystem.mbg.model.Owner;
import com.sugar.wyglsystem.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 9:39
 * @description：
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> noticeList = noticeMapper.selectByExample(new NoticeExample());
        if (noticeList.size() > 0) {
            return noticeList;
        }
        return null;
    }

    @Override
    public int deleteNotice(Long id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Notice getNoticeById(Long id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Notice> getNoticeByTitle(String title, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        NoticeExample example = new NoticeExample();
        example.createCriteria().andTitleLike("%" + title + "%");
        List<Notice> noticeList = noticeMapper.selectByExample(example);
        if (noticeList.size() > 0) {
            return noticeList;
        }
        return null;
    }

    @Override
    public List<Notice> getNoticeByType(Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        NoticeExample example = new NoticeExample();
        example.createCriteria().andTypeEqualTo(type);
        List<Notice> noticeList = noticeMapper.selectByExample(example);
        if (noticeList.size() > 0) {
            return noticeList;
        }
        return null;
    }

    @Override
    public int updateNotice(Long id, Notice notice) {
        notice.setId(id);
        return noticeMapper.updateByPrimaryKey(notice);
    }

    @Override
    public Notice insertNotice(Notice notice) {
        int insert = noticeMapper.insert(notice);
        if (insert > 0) {
            return notice;
        }
        return null;
    }
}
