package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.dto.FeeDetailsDto;
import com.sugar.wyglsystem.mbg.model.FeeDetails;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 11:41
 * @description：
 */
public interface FeeDetailsService {
    int insert(FeeDetails feeDetails);

    List<FeeDetailsDto> getFeeDetailsList(Long roomId, Integer pageNum, Integer pageSize);
}
