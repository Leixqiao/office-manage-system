package com.leixiaoqiao.pojo;

import lombok.Data;
/***
 * @description:用户表的实体类
 */
@Data
public class User{
    private Integer id;
    private String userName;
    private String loginName;
    private String password;
    private Integer role;
}