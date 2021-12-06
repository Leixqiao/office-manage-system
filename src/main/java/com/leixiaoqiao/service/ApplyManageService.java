package com.leixiaoqiao.service;

import com.github.pagehelper.PageInfo;
import com.leixiaoqiao.pojo.Apply;


import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-12-02 14:14:54
 */
public interface ApplyManageService {

    PageInfo<Apply> getPage(HashMap<String, Object> map);

    Boolean updateApplyState(Integer applyId, Integer applyState);

    Boolean updateStates(Integer state, List<Integer> ids);

    Boolean addApply(Apply apply);

    PageInfo<Apply> getMyApply(Integer pageNum, Integer pageSize, String articleName, Integer articleType, Integer userId);
}
