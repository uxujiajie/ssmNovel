package com.ssm.test.domain;

import java.util.List;

/**
 * Book扩展类
 *
 * @author xu
 * @create 2017-07-25-17:51
 */
public class BookExam extends Book {
        private List<CommentExam> commentExamList;
        private User user;
        private List<Section> sectionList;
        private List<Category> categoryList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CommentExam> getCommentExamList() {
        return commentExamList;
    }

    public void setCommentExamList(List<CommentExam> commentExamList) {
        this.commentExamList = commentExamList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
