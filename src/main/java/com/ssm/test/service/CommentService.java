package com.ssm.test.service;

import com.ssm.test.domain.Comment;
import com.ssm.test.domain.CommentExam;

import java.util.List;

/**
 * Created by xu on 2017/7/30.
 */
public interface CommentService {

    /**
     * 用户查看评论
     */
    List<CommentExam> userLookComment(Integer userId);

    /**
     * 用户发表评论
     */
    void addCommentByUser(Comment comment);
}
