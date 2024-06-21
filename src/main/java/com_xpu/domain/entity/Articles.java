package com_xpu.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("articles")
@ApiModel(value="Articles对象", description="")
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键 id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "唯一 ID")
    private String articleId;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "正文")
    private String content;

    @ApiModelProperty(value = "分类id")
    private Integer category;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "查看数")
    private Integer view;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
