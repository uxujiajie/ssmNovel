package com.ssm.test.domain;

/**
 * 章节扩充类
 *
 * @author xu
 * @create 2017-07-28-9:08
 */
public class SecExam extends Section {

    /**
     * 小说内容
     */
    private String content;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 书的分类
     */
    private Integer bookNum;

    /**
     * 书地址
     */
    private String bookUrl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }
}
