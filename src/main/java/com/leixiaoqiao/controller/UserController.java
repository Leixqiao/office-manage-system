package com.leixiaoqiao.controller;

import com.leixiaoqiao.api.constant.CommonConstant;
import com.leixiaoqiao.api.vo.Result;
import com.leixiaoqiao.pojo.User;
import com.leixiaoqiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 用户登录控制器
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 17:42:01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    //前端通过请求头发送数据
    public Result<?> login(@RequestBody User loginUser){
        User user = userService.findUserByName(loginUser.getLoginName());
        if (user!=null){
            //判断密码是否正确
            if (loginUser.getPassword().equals(user.getPassword())){
                return Result.ok(user,"登陆成功");
            }
        }
        return Result.error(CommonConstant.LOGIN_PASSWORD_ERROR,CommonConstant.LOGIN_ERROR_MESSAGE);
    }

    @GetMapping("/{userId}")
    public Result<?> getUserById(@PathVariable Integer userId){
        User user=userService.findUserById(userId);
        if (user!=null){
            return Result.ok(user,"用户查找成功");
        }
        return Result.error("用户查找失败，请登录后操作！");
    }
}
