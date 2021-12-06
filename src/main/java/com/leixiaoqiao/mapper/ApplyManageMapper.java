package com.leixiaoqiao.mapper;

import com.leixiaoqiao.pojo.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-12-02 14:52:30
 */
public interface ApplyManageMapper {

    List<Apply> selectApplyList(HashMap<String, Object> map);

    int updateApplyState(@Param("applyId") Integer applyId, @Param("applyState") Integer applyState);

    int updateStates(@Param("state") Integer state, @Param("ids") List<Integer> ids);

    int addApply(Apply apply);

    List<Apply> selectMyApplyListByUserId(@Param("articleName") String articleName,
                                          @Param("articleType") Integer articleType,
                                          @Param("userId") Integer userId);
}
