package com.ssm.test.service.impl;

import com.ssm.test.domain.*;
import com.ssm.test.mapper.BookMapper;
import com.ssm.test.mapper.CategoryMapper;
import com.ssm.test.mapper.SectionMapper;
import com.ssm.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 图书逻辑层
 *
 * @author xu
 * @create 2017-07-24-10:51
 */
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private SectionMapper sectionMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据主键查询图书信息
     * @param id
     * @return
     */
    public BookExam findBookById(Integer id) {
        BookExam bookExam = bookMapper.selectByPriKeyAndUserComm(id);
        /**
         * 查询所有章节
         */
        bookExam.setSectionList(sectionMapper.selectByBookId(id) );
        /**
         * 查询所属的分类
         */
        List<Category> categoryList = new ArrayList<Category>();
        Category category = categoryMapper.selectByPrimaryKey(bookExam.getCategoryid() );
        categoryList.add(category);
        if(category != null) {
            while (category.getParentid() != null) {
                category = categoryMapper.selectByPrimaryKey(category.getParentid());
                categoryList.add(category);
            }
        }
        Collections.reverse(categoryList);
        bookExam.setCategoryList(categoryList);
        return bookExam;
    }
    /**
     * 根据作者或书名查询图书
     */
    public List<Book> findByAuthorOrName(String authorOrName) {
        Book book = new Book();
        book.setBookname("'%"+authorOrName+"%'");
        book.setAuthor("'%"+authorOrName+"%'");
        return bookMapper.selectByAuthorOrName(authorOrName);
    }

    public List<Book> findIndexBook() {
        return bookMapper.selectBookOrderByHit();
    }

    public BookQueryVo findWriterBook(int userId) {
        BookQueryVo bookQueryVo = new BookQueryVo();
        bookQueryVo.setBookList(bookMapper.selectByUserId(userId) );

        return bookQueryVo;
    }

    /**
     * 初始化pageBean
     * @param tr
     * @return
     */
    PageBean<Book> getPageBean(Integer pc, Integer tr) {
        PageBean<Book> pageBean = new PageBean();
        pageBean.setPc(pc);
        pageBean.setPs(10);
        /**
         * 查询总记录数
         */
        if(tr == null)
            pageBean.setTr(bookMapper.selectCount() );
        else
            pageBean.setTr(tr);
        return pageBean;
    }
    /**
     * 查询所有书
     * @param pc
     * @param tr
     * @return
     */
    public PageBean<Book> findAllBookByPage(Integer pc, Integer tr) {
        PageBean<Book> pageBean = getPageBean(pc, tr);
        /**
         * 查询记录 (pc-1)*ps+1 ,  pc*ps
         */
        pageBean.setBeanList(bookMapper.selectByPage((pc-1)*pageBean.getPs(), pc*pageBean.getPs() ) );
        return pageBean;
    }
    /**
     * 查询所有书（按照点击量)
     * @param pc
     * @param tr
     * @return
     */
    public PageBean<Book> findAllBookByPageHits(Integer pc, Integer tr) {
        PageBean<Book> pageBean = getPageBean(pc, tr);
        /**
         * 查询记录 (pc-1)*ps+1 ,  pc*ps
         */
        pageBean.setBeanList(bookMapper.selectByPageHits((pc-1)*pageBean.getPs(), pc*pageBean.getPs() ) );
        return pageBean;
    }
    /**
     * 查询所有书(按照创建时间)
     * @param pc
     * @param tr
     * @return
     */
    public PageBean<Book> findAllBookByPageCreate(Integer pc, Integer tr) {
        PageBean<Book> pageBean = getPageBean(pc, tr);
        /**
         * 查询记录 (pc-1)*ps+1 ,  pc*ps
         */
        pageBean.setBeanList(bookMapper.selectByPageCreateDate((pc-1)*pageBean.getPs(), pc*pageBean.getPs() ) );
        return pageBean;
    }
    /**
     * 查询所有书(按照跟新时间)
     * @param pc
     * @param tr
     * @return
     */
    public PageBean<Book> findAllBookByUpdate(Integer pc, Integer tr) {
        PageBean<Book> pageBean = getPageBean(pc, tr);
        /**
         * 查询记录 (pc-1)*ps+1 ,  pc*ps
         */
        pageBean.setBeanList(bookMapper.selectByPageUpdateTime((pc-1)*pageBean.getPs(), pc*pageBean.getPs() ) );
        return pageBean;
    }

    /**
     * 添加图书
     * @param book
     */
    public void addWriterBook(Book book) {
        //设置点击数
        book.setHits(0);
        book.setBooknum(0);
        //设置更新时间
        Timestamp timestamp = new Timestamp(new Date().getTime() );
        book.setUpdatetime(timestamp );
        //设置创建时间
        book.setCreatedate(new Date() );

        bookMapper.insert(book);
    }
    /**
     * 添加书架
     */
    public void addBookRack(Integer userId,Integer bookId){
            bookMapper.insertBookRack(userId,bookId);
    }
}
