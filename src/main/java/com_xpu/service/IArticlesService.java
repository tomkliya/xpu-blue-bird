package com_xpu.service;

import com_xpu.domain.entity.Articles;
import com.baomidou.mybatisplus.extension.service.IService;
import com_xpu.domain.dto.ArticlesDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
public interface IArticlesService extends IService<Articles> {

    Boolean addArticle(ArticlesDTO articlesDTO);

}
