package com_xpu.service.impl;

import com_xpu.domain.entity.Category;
import com_xpu.mapper.CategoryMapper;
import com_xpu.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
