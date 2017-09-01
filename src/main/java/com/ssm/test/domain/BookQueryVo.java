package com.ssm.test.domain;

import java.util.List;

/**
 * book查询的vo，包括很多
 *
 * @author xu
 * @create 2017-07-24-10:54
 */
public class BookQueryVo {
    private User user;
    private Book book;
    private List<Book> bookList;
    private List<Comment> commentList;

    public BookQueryVo() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
