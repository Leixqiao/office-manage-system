package com.leixiaoqiao.pojo;
import lombok.Data;
/***
 * @description:申请表的实体类
 */
@Data
public class Apply {
    private Integer id;
    private Integer userId;
    private Integer articleId;
    private Integer applyNum;
    private String applyUnit;
    private String applyReason;
    private String applyDate;
    private Integer applyState;

    //关联映射属性
    private User user;
    private Article article;
}