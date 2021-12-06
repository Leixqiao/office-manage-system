package com.leixiaoqiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leixiaoqiao.mapper.ApplyManageMapper;
import com.leixiaoqiao.pojo.Apply;
import com.leixiaoqiao.service.ApplyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-12-02 14:45:01
 */
@Service
@Transactional
public class ApplyManageServiceImpl implements ApplyManageService {

    @Autowired
    private ApplyManageMapper applyManageMapper;

    @Override
    public PageInfo<Apply> getPage(HashMap<String, Object> map) {
        //设置参数
        PageHelper.startPage((Integer)(map.get("pageNum")),
                (Integer)(map.get("pageSize")));
        //调用查询方法
        List<Apply> applyList = applyManageMapper.selectApplyList(map);
        //组装返回,注意构造参数
        return new PageInfo<>(applyList);
    }

    @Override
    public Boolean updateApplyState(Integer applyId, Integer applyState) {
        int rows=applyManageMapper.updateApplyState(applyId,applyState);
        if (rows>0){
            return true;
        }return false;
    }

    @Override
    public Boolean updateStates(Integer state, List<Integer> ids) {
        int rows=applyManageMapper.updateStates(state,ids);
        if (rows==ids.size()){
            return true;
        }return false;
    }

    @Override
    public Boolean addApply(Apply apply) {
        int rows=applyManageMapper.addApply(apply);
        if (rows>0){
            return true;
        }return false;
    }

    @Override
    public PageInfo<Apply> getMyApply(Integer pageNum, Integer pageSize, String articleName, Integer articleType, Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Apply> applyList = applyManageMapper.selectMyApplyListByUserId(articleName,articleType,userId);
        return new PageInfo<>(applyList);
    }
}
