package com.ssm.test.mapper;

import com.ssm.test.domain.Comment;
import java.util.List;

import com.ssm.test.domain.CommentExam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<CommentExam> selectByUserId(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}