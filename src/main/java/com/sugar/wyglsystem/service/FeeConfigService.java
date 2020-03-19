package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.mbg.model.Fee;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/18 17:01
 * @description：
 */
public interface FeeConfigService {
    List<Fee> getFeeList(Integer pageNum,Integer pageSize);

    List<Fee> getFeeByFeeFlag(Integer feeFlag,Integer pageNum,Integer pageSize);

    List<Fee> getFeeByFeeType(Integer type,Integer pageNum,Integer pageSize);

    Fee getFeeByFeeItem(String feeItem);

    int delete(Long id);

    int update(Long id,Fee fee);

    int insert(Fee fee);
}
