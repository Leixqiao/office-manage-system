package com.leixiaoqiao.controller;

import com.github.pagehelper.PageInfo;
import com.leixiaoqiao.api.vo.Result;
import com.leixiaoqiao.pojo.Article;
import com.leixiaoqiao.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 物品后端处理器
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 20:19:53
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/page")
    public Result<?> page(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "5") Integer pageSize
                            ,String articleName,Integer articleType){

        HashMap<String, Object> map = new HashMap<>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("articleName",articleName);
        map.put("articleType",articleType);
        PageInfo<Article> pageInfo = articleService.getPage(map);

        return Result.ok(pageInfo);
    }

    @PostMapping
    public Result<?> addArticle(@RequestBody Article article){
        Boolean tag=articleService.addArticle(article);
        if (tag){
            return Result.ok("添加成功！");
        }else {
        return Result.error("添加失败");
        }
    }

    @GetMapping("/{id}")
    public Result<?> getArticleById(@PathVariable Integer id){
        Article article = articleService.getArticleById(id);
        if (article!=null){
            return Result.ok(article,"查找成功！");
        }else {
            return Result.error("查找失败");
        }
    }

    @PutMapping
    public Result<?> putArticle(@RequestBody Article article){
        Boolean tag=articleService.changeArticle(article);
        if (tag){
            return Result.ok("修改成功！");
        }else {
            return Result.error("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> deleteArticleById(@PathVariable Integer id){
        Boolean tag=articleService.deleteArticleById(id);
        if (tag){
            return Result.ok("删除成功！");
        }else {
            return Result.error("删除失败");
        }
    }

    @DeleteMapping
    public Result<?> deleteArticleById(@RequestBody List<Integer> ids){
        Boolean tag=articleService.deleteArticleByIds(ids);
        if (tag){
            return Result.ok("批量删除成功！");
        }else {
            return Result.error("批量删除失败");
        }
    }

    @GetMapping("/getArticle/{articleId}")
    public Result<?> getArticle(@PathVariable Integer articleId){
        Article article = articleService.getArticle(articleId);
        if (article!=null){
            return Result.ok(article,"查找物品信息成功！");
        }else {
            return Result.error("查找物品信息失败");
        }
    }

    @PutMapping("/updateStockNum")
    public Result<?> updateStockNum(@RequestParam Integer flag,@RequestParam Integer articleId,@RequestParam Integer applyNum){

        Boolean tag=articleService.updateArticleStockNum(flag,articleId,applyNum);
        if (tag){
            return Result.ok("修改库存成功");
        }else {
            return Result.error("修改库存失败");
        }
    }
}
