package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Unit;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/6 15:24
 * @description：
 */
@Data
public class UnitDto implements Serializable {
    private static final long serialVersionUID = 1L;
    List<Unit> list;
}
