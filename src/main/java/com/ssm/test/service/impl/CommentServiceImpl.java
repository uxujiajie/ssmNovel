package com.ssm.test.service.impl;

import com.ssm.test.domain.Comment;
import com.ssm.test.domain.CommentExam;
import com.ssm.test.mapper.CommentMapper;
import com.ssm.test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 评论逻辑层实现类
 *
 * @author xu
 * @create 2017-07-30-18:41
 */
public class CommentServiceImpl implements CommentService {
   @Autowired
    private CommentMapper commentMapper;
    /**
     * 用户查看评论
     */
    public List<CommentExam> userLookComment(Integer userId) {
        return commentMapper.selectByUserId(userId);
    }

    /**
     * 用户评论
     * @param comment
     */
    public void addCommentByUser(Comment comment) {
        commentMapper.insert(comment);
    }
}
