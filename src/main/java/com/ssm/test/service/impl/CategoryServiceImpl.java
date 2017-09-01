package com.ssm.test.service.impl;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.Category;
import com.ssm.test.domain.PageBean;
import com.ssm.test.mapper.CategoryMapper;
import com.ssm.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 分类逻辑层实现类
 *
 * @author xu
 * @create 2017-07-24-15:07
 */
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 查询所有分类
     */
    public List<Category> findAllCate() {
        return categoryMapper.selectAllCate();
    }

    /**
     * 查询一级分类
     * @return
     */
    public List<Category> findAllFirCate() {
        return categoryMapper.selectFirCate();
    }

    /**
     * 查询一级分类及其二级子分类
     * @return
     */
    public List<Category> findFirIsSecCate(Integer id) {
        return categoryMapper.selectFirAndSecCate(id);
    }
    /**
     * 查询分类下的书籍(带分页)
     */
    public PageBean<Book> findBookByListId(List<Category> categoryList,Integer pc,Integer tr) {
        if(pc == null || pc <= 0)
            pc = 1;
        PageBean<Book> pageBean = new PageBean<Book>();
        pageBean.setPc(pc);
        pageBean.setPs(10);
        if (tr == null)
            pageBean.setTr(categoryMapper.selectCountByCate(categoryList) );       //查询总记录数
        else
            pageBean.setTr(tr);
        pageBean.setBeanList(categoryMapper.selectBookByCate(categoryList,
                (pc-1)*pageBean.getPs(),pc*pageBean.getPs()-1) );
        return pageBean;
    }

}
