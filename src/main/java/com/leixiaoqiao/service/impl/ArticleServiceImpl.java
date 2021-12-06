package com.leixiaoqiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leixiaoqiao.mapper.ArticleMapper;
import com.leixiaoqiao.pojo.Article;
import com.leixiaoqiao.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 20:23:39
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> getPage(HashMap<String, Object> queryParamMap) {
        //设置参数
        PageHelper.startPage((Integer)(queryParamMap.get("pageNum")),
                (Integer)(queryParamMap.get("pageSize")));
        //调用查询方法
        List<Article> articleList = articleMapper.selectJoinTypeAll(queryParamMap);
        //组装返回,注意构造参数
        return new PageInfo<>(articleList);
    }

    @Override
    public Boolean addArticle(Article article) {
        int rows=articleMapper.insertArticle(article);
        if (rows>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectArticleById(id);
    }

    @Override
    public Boolean changeArticle(Article article) {
        int rows=articleMapper.updateArticle(article);
        if (rows>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean deleteArticleById(Integer id) {
        int rows=articleMapper.deleteById(id);
        if (rows>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean deleteArticleByIds(List<Integer> ids) {
        for (Integer id : ids) {
            if (articleMapper.selectArticleById(id)==null){
                return false;
            }
        }
        int rows=articleMapper.deleteByIds(ids);
        if (rows==ids.size()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Article getArticle(Integer articleId) {
        return articleMapper.selectArticleAndType(articleId);
    }

    @Override
    public Boolean updateArticleStockNum(Integer flag, Integer articleId, Integer applyNum) {
        int updateNum = -1;
        if (flag==1){
            updateNum=articleMapper.selectArticleById(articleId).getStockNum()+applyNum;
        }else if (flag==-1){
            updateNum=articleMapper.selectArticleById(articleId).getStockNum()-applyNum;
        }
        if (updateNum>=0){
            int num = articleMapper.updateArticleStockNum(articleId, updateNum);
            if (num>0){
                return true;
            }return false;
        }else throw new RuntimeException("更新库存参数非法！");
    }

}
