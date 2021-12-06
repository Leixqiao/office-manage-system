package com.leixiaoqiao.service.impl;

import com.leixiaoqiao.mapper.ArticleTypeMapper;
import com.leixiaoqiao.pojo.ArticleType;
import com.leixiaoqiao.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @company: yaorange
 * @author: Mr.Huang
 * @version: 1.0
 * @create: 2021-11-29 14:19:03
 */
@Service
@Transactional
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public List<ArticleType> getList() {
        return articleTypeMapper.selectList();
    }
}
