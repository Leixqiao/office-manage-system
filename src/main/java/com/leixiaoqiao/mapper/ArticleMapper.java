package com.leixiaoqiao.mapper;

import com.leixiaoqiao.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 20:25:51
 */
public interface ArticleMapper {

    List<Article> selectJoinTypeAll(HashMap<String, Object> queryMap);

    int insertArticle(Article article);

    Article selectArticleById(Integer id);

    int updateArticle(Article article);

    int deleteById(Integer id);

    int deleteByIds(@Param("ids") List<Integer> ids);

    Article selectArticleAndType(Integer articleId);

    int updateArticleStockNum(@Param("articleId") Integer articleId, @Param("updateNum") Integer updateNum);
}
