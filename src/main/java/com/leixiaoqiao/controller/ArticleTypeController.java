package com.leixiaoqiao.controller;

import com.leixiaoqiao.api.vo.Result;
import com.leixiaoqiao.pojo.ArticleType;
import com.leixiaoqiao.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articleType")
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/list")
    public Result<?> list(){
        List<ArticleType> articleTypeList = articleTypeService.getList();
        return Result.ok(articleTypeList);
    }
}