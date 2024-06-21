package com_xpu.service.impl;

import com_xpu.domain.entity.Comment;
import com_xpu.mapper.CommentMapper;
import com_xpu.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
