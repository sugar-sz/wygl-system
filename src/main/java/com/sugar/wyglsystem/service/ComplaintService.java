package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.ComplaintAndRoomInfoDto;
import com.sugar.wyglsystem.mbg.model.Complaint;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/16 13:16
 * @description： 投诉信息
 */
public interface ComplaintService {
    Complaint insertComplaint(Complaint complaint);

    List<ComplaintAndRoomInfoDto> getComplaintList(Integer pageNum,Integer pageSize);

    int deleteComplaint(Long id);

    ComplaintAndRoomInfoDto getComplaintById(Long id);

    List<ComplaintAndRoomInfoDto> getComplaintByName(String name, Integer pageNum, Integer pageSize);

    List<ComplaintAndRoomInfoDto> getComplaintByType(Integer type, Integer pageNum, Integer pageSize);

    int updateComplaint(Long id, Complaint complaint);

}
