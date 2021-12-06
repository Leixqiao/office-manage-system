package com.leixiaoqiao.service;

import com.leixiaoqiao.pojo.User;

/**
 * @description: 用户登录的业务层接口
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 17:36:34
 */
public interface UserService {
    User findUserByName(String loginName);

    User findUserById(Integer userId);
}
