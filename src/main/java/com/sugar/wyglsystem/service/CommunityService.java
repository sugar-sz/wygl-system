package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.Community;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/3 9:31
 * @description：
 */
public interface CommunityService {
    /**
     * 功能描述: <br>
     *
     * @Param: 当前adminid
     * @Return: admin管理的所有小区
     * @Author: luyujie
     * @Date: 2020/3/3 9:35
     */
    List<Community> getCommunityList(Long id, Integer pageNum, Integer pageSize);

    /**
     * 功能描述: <br>
     *
     * @Param: 小区id
     * @Return:
     * @Author: luyujie
     * @Date: 2020/3/3 13:35
     */
    int deleteCommunity(Long id);

    /**
     * 功能描述: <br>
     *
     * @Param: 小区id
     * @Return: com.sugar.wyglsystem.mbg.model.Community
     * @Author: luyujie
     * @Date: 2020/3/3 13:41
     */
    Community getCommunityById(Long id);

    int updateCommunity(Long id, Community community);

    Community insertCommunity(Community community);

    int deleteListCommunity(List<Long> idList);
}
