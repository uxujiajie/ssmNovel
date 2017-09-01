package com.ssm.test.domain;

/**
 * 评论扩展类
 *
 * @author xu
 * @create 2017-07-26-10:04
 */
public class CommentExam extends Comment {
    private User user;
    private Book book;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
