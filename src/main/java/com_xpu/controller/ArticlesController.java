package com_xpu.controller;


import com_xpu.domain.entity.Result;
import com_xpu.domain.vo.ArticlesVO;
import com_xpu.service.impl.ArticlesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-20
 */
@RestController
@RequestMapping("/v1/articles")
@Slf4j
@Api(tags = "文章相关接口")
public class ArticlesController {
@Resource(type=ArticlesServiceImpl.class)
private ArticlesServiceImpl articlesService;

    @PostMapping("/add")
    @ApiOperation("添加文章")
    public Result addArticle(@RequestBody ArticlesVO articlesVO){
        log.info("添加文章:{}",articlesVO.toString());
        Boolean b = articlesService.addArticle(articlesVO);
        return Result.success(b);
    }

}
