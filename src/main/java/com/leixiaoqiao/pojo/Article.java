package com.leixiaoqiao.pojo;

import lombok.Data;
/***
 * @description:物品表的实体类
 */
@Data
public class Article{
    private Integer id;
    private String articleName;
    private Integer stockNum;
    private String stockUnit;
    private Integer articleType;
    private String articleDescribe;
    //关联对象
    private ArticleType type;
}
