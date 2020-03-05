package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Building;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/5 20:29
 * @description：
 */
@Data
public class BuildingDto implements Serializable {
    private List<Building> list;
    private static final long serialVersionUID = 1L;
}
