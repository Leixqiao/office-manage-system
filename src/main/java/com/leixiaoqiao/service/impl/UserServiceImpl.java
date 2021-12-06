package com.leixiaoqiao.service.impl;

import com.leixiaoqiao.mapper.UserMapper;
import com.leixiaoqiao.pojo.User;
import com.leixiaoqiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 17:46:09
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String loginName) {
        return userMapper.selectUserByName(loginName);
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }
}
