package com.ssm.test.service;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.BookExam;
import com.ssm.test.domain.BookQueryVo;
import com.ssm.test.domain.PageBean;

import java.util.List;

/**
 * Created by xu on 2017/7/24.
 */
public interface BookService {
    /**
     * 查询图书信息(根据主键)
     */
    BookExam findBookById(Integer id);
    /**
     * 根据作者或书名查询图书
     */
    List<Book> findByAuthorOrName(String authorOrName);
    /**
     * 首页查询图书12本，按点击数
     */
    List<Book> findIndexBook();
    /**
     * 查询作者写的图书
     */
    BookQueryVo findWriterBook(int userId);
    /**
     * 查询所有图书(分页)
     */
    PageBean<Book> findAllBookByPage(Integer pc, Integer tr);
    PageBean<Book> findAllBookByPageHits(Integer pc, Integer tr);
    PageBean<Book> findAllBookByPageCreate(Integer pc, Integer tr);
    PageBean<Book> findAllBookByUpdate(Integer pc, Integer tr);
    /**
     * 添加图书
     */
    void addWriterBook(Book book);
    /**
     * 修改图书
     */
    /**
     * 添加图书
     */
    void addBookRack(Integer userId,Integer bookId);
}
