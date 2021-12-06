package com.leixiaoqiao.mapper;

import com.leixiaoqiao.pojo.User;

/**
 * @description: 用户登录的持久层接口
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 17:39:24
 */
public interface UserMapper {

    User selectUserByName(String loginName);

    User selectUserById(Integer userId);
}
