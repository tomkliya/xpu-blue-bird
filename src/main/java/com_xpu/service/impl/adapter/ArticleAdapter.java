package com_xpu.service.impl.adapter;

import com_xpu.domain.entity.Articles;
import com_xpu.domain.vo.ArticlesVO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ArticleAdapter {

    public Articles NewArticles(ArticlesVO articlesVO) {
        String uuid = UUID.randomUUID().toString();
        return Articles.builder()
                .articleId(uuid)
                .title(articlesVO.getTitle())
                .content(articlesVO.getContent())
                .category(articlesVO.getCategory())
                .status(0)
                //阅读初始化
                .view(0)
                .createBy("用户id")
                .build();

    }
}
