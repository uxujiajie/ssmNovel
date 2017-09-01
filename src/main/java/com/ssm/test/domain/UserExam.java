package com.ssm.test.domain;

import java.util.List;

/**
 * 用户扩展类
 *
 * @author xu
 * @create 2017-07-29-17:25
 */
public class UserExam extends User {
    /**
     * 用户的书架
     */
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
