package com.sugar.wyglsystem.dao;

import com.sugar.wyglsystem.dto.FeeDetailsDto;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 12:49
 * @description：
 */
public interface FeeDetailsDao {
    List<FeeDetailsDto>  getFeeDetailsList(Long roomId);
}
