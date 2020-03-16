package com.sugar.wyglsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dao.ComplaintDao;
import com.sugar.wyglsystem.dto.ComplaintAndRoomInfoDto;
import com.sugar.wyglsystem.mbg.mapper.ComplaintMapper;
import com.sugar.wyglsystem.mbg.model.Complaint;
import com.sugar.wyglsystem.mbg.model.ComplaintExample;
import com.sugar.wyglsystem.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 13:17
 * @description：
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;

    @Autowired
    private ComplaintDao complaintDao;

    @Override
    public Complaint insertComplaint(Complaint complaint) {
        complaint.setCreateTime(new Date());
        complaintMapper.insert(complaint);
        return complaint;
    }

    @Override
    public List<ComplaintAndRoomInfoDto> getComplaintList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ComplaintAndRoomInfoDto> complaintInfo = complaintDao.getComplaintInfo();
        System.out.println(complaintInfo);
        if (complaintInfo.size() > 0) {
            return complaintInfo;
        }
        return null;
    }

    @Override
    public int deleteComplaint(Long id) {
        return complaintMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ComplaintAndRoomInfoDto getComplaintById(Long id) {
        return complaintDao.getComplaintById(id);
    }

    @Override
    public List<ComplaintAndRoomInfoDto> getComplaintByName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(name);
        return complaintDao.getComplaintByName("%" + name + "%");
    }

    @Override
    public List<ComplaintAndRoomInfoDto> getComplaintByType(Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return complaintDao.getComplaintByType(type);
    }

    @Override
    public int updateComplaint(Long id, Complaint complaint) {
        complaint.setId(id);
        return complaintMapper.updateByPrimaryKey(complaint);
    }
}
