package com_xpu.domain.dto;

import lombok.Data;

@Data
public class ArticlesDTO {
    /**
     * 文章标题
     */
    private String title;

    /**
     * 正文
     */
    private String content;

    /**
     * 分类id
     */
    private Integer category;
}
