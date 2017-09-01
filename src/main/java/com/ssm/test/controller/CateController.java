package com.ssm.test.controller;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.Category;
import com.ssm.test.domain.PageBean;
import com.ssm.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 分类controller
 *
 * @author xu
 * @create 2017-07-26-14:55
 */
@Controller
public class CateController {
    @Autowired
    private CategoryService categoryService;
    /**
     * 查找一级分类和下属二级分类以及图书
     * @return
     */
    @RequestMapping(value = "findFirCateOfBook/{cateId}")
    public String findFirCateOfBook(@PathVariable("cateId") Integer cateId, Integer pc, Integer tr, Model model) throws Exception {
        if(cateId == null)
            return "msg";
        List<Category> categoryList = categoryService.findFirIsSecCate(cateId);
        model.addAttribute("categoryList", categoryList);
        PageBean<Book> pageBean = categoryService.findBookByListId(categoryList, pc, tr);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("uCateId", cateId);
        return "/cateListBook";
    }

}
