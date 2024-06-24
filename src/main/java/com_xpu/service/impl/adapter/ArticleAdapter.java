package com_xpu.service.impl.adapter;

import com_xpu.domain.entity.Articles;
import com_xpu.domain.dto.ArticlesDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ArticleAdapter {

    public Articles NewArticles(ArticlesDTO articlesDTO) {
        String uuid = UUID.randomUUID().toString();
        return Articles.builder()
                .articleId(uuid)
                .title(articlesDTO.getTitle())
                .content(articlesDTO.getContent())
                .category(articlesDTO.getCategory())
                .status(0)
                //阅读初始化
                .view(0)
                .createBy("用户id")
                .build();

    }
}
