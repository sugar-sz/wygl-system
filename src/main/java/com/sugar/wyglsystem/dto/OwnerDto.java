package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Owner;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/5 13:34
 * @description：
 */
@Data
public class OwnerDto implements Serializable {
    List<Owner> list;
    private static final long serialVersionUID = 1L;
}
