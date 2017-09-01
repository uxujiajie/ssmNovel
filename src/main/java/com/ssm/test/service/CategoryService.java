package com.ssm.test.service;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.Category;
import com.ssm.test.domain.PageBean;

import java.util.List;

/**
 * Created by xu on 2017/7/24.
 */
public interface CategoryService {
    /**
     * 查询所有分类
     */
    List<Category> findAllCate();
    /**
     * 查询所有一级分类
     */
    List<Category> findAllFirCate();
    /**
     * 查询一级分类及其二级子分类
     */
    List<Category> findFirIsSecCate(Integer id);
    /**
     * 查询分类下的书籍
     */
    PageBean<Book> findBookByListId(List<Category> categoryList,Integer pc,Integer tr);
}
