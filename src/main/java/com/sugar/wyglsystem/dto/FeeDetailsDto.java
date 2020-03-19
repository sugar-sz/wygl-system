package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Fee;
import com.sugar.wyglsystem.mbg.model.FeeDetails;
import lombok.Data;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 12:51
 * @description：
 */
@Data
public class FeeDetailsDto {
    Fee fee;
    FeeDetails feeDetails;
}
