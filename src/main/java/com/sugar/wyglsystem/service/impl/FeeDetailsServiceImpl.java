package com.sugar.wyglsystem.service.impl;

import com.alibaba.druid.sql.dialect.odps.ast.OdpsAddStatisticStatement;
import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.dao.FeeDetailsDao;
import com.sugar.wyglsystem.dto.FeeDetailsDto;
import com.sugar.wyglsystem.mbg.mapper.FeeDetailsMapper;
import com.sugar.wyglsystem.mbg.model.FeeDetails;
import com.sugar.wyglsystem.service.FeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 11:41
 * @description：
 */
@Service
public class FeeDetailsServiceImpl implements FeeDetailsService {
    @Autowired
    private FeeDetailsMapper feeDetailsMapper;

    @Autowired
    private FeeDetailsDao feeDetailsDao;

    @Override
    public int insert(FeeDetails feeDetails) {
        feeDetails.setCreateTime(new Date());
        return feeDetailsMapper.insert(feeDetails);
    }

    @Override
    public List<FeeDetailsDto> getFeeDetailsList(Long roomId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return feeDetailsDao.getFeeDetailsList(roomId);
    }

    @Override
    public int update(Long id, FeeDetails feeDetails) {
        feeDetails.setId(id);
        return feeDetailsMapper.updateByPrimaryKey(feeDetails);
    }

    @Override
    public int delete(Long id) {
        return feeDetailsMapper.deleteByPrimaryKey(id);
    }
}
