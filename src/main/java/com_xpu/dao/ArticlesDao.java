package com_xpu.dao;

import com_xpu.domain.entity.Articles;
import com_xpu.mapper.ArticlesMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
public class ArticlesDao {
    @Resource(type = ArticlesMapper.class)
    private ArticlesMapper articlesMapper;
    public boolean save(Articles articles) {
        int insert = articlesMapper.insert(articles);
        return insert==1;
    }
}
