package com_xpu.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eumenides
 * @description  文章状态枚举
 * @date 2024/6/20
 */

public class ArticleStatus {
//
//    CREATED(0, "初始化"),
//    DELETED(3, "已删除");

    public static  Integer CREATED = 0; //初始化

    public static final Integer DELETED = 3;//逻辑删除

}
