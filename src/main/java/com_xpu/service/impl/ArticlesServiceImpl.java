package com_xpu.service.impl;

import com_xpu.dao.ArticlesDao;
import com_xpu.domain.entity.Articles;
import com_xpu.domain.dto.ArticlesDTO;
import com_xpu.mapper.ArticlesMapper;
import com_xpu.service.IArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_xpu.service.impl.adapter.ArticleAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements IArticlesService {

    @Resource(type = ArticleAdapter.class)
    private ArticleAdapter articleAdapter;
    @Resource(type = ArticlesDao.class)
    private ArticlesDao articlesDao;

    @Override
    public Boolean addArticle(ArticlesDTO articlesDTO) {

        Articles articles = articleAdapter.NewArticles(articlesDTO);
        return articlesDao.save(articles);

    }
}
