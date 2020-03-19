package com.sugar.wyglsystem.service;

import com.github.pagehelper.PageHelper;
import com.sugar.wyglsystem.mbg.mapper.FeeMapper;
import com.sugar.wyglsystem.mbg.model.Fee;
import com.sugar.wyglsystem.mbg.model.FeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/18 17:11
 * @description： 费用项管理
 */
@Service
public class FeeConfigServiceImpl implements FeeConfigService {
    @Autowired
    private FeeMapper feeMapper;

    @Override
    public List<Fee> getFeeList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return feeMapper.selectByExample(new FeeExample());
    }

    @Override
    public List<Fee> getFeeByFeeFlag(Integer feeFlag, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FeeExample example = new FeeExample();
        example.createCriteria().andFeeFlagEqualTo(feeFlag);
        return feeMapper.selectByExample(example);
    }

    @Override
    public List<Fee> getFeeByFeeType(Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FeeExample example = new FeeExample();
        example.createCriteria().andTypeEqualTo(type);
        return feeMapper.selectByExample(example);
    }

    @Override
    public Fee getFeeByFeeItem(String feeItem) {
        FeeExample example = new FeeExample();
        example.createCriteria().andFeeItemLike(feeItem);
        List<Fee> feeList = feeMapper.selectByExample(example);
        if (feeList.size() > 0) {
            return feeList.get(0);
        }
        return null;
    }

    @Override
    public int delete(Long id) {
        return feeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, Fee fee) {
        fee.setId(id);
        return feeMapper.updateByPrimaryKey(fee);
    }

    @Override
    public int insert(Fee fee) {
        fee.setCreateTime(new Date());
        return feeMapper.insert(fee);
    }
}
