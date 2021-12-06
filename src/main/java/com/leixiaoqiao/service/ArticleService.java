package com.leixiaoqiao.service;

import com.github.pagehelper.PageInfo;
import com.leixiaoqiao.pojo.Article;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 20:22:24
 */
public interface ArticleService {

    PageInfo<Article> getPage(HashMap<String, Object> queryParamMap);

    Boolean addArticle(Article article);

    Article getArticleById(Integer id);

    Boolean changeArticle(Article article);

    Boolean deleteArticleById(Integer id);

    Boolean deleteArticleByIds(List<Integer> ids);

    Article getArticle(Integer articleId);

    Boolean updateArticleStockNum(Integer flag, Integer articleId, Integer applyNum);
}
