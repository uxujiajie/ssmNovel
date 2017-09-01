package com.ssm.test.controller;

import com.ssm.test.domain.Book;
import com.ssm.test.domain.Category;
import com.ssm.test.service.BookService;
import com.ssm.test.service.CategoryService;
import com.ssm.test.util.PropUril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

/**
 * 首页跳转控制器
 *
 * @author xu
 * @create 2017-07-23-9:45
 */
@Controller
public class IndexController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/turnIndex")
    public String turnIndex(Model model, HttpServletRequest request) throws Exception {
        //首页显示书籍
        List<Book> bookList = bookService.findIndexBook();
        //首页显示分类
        List<Category> categoryList = categoryService.findAllFirCate();
        model.addAttribute("bookList", bookList);
        model.addAttribute("categoryList", categoryList);

        String ip = getUserIp(request);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ip = sdf.format(new Date()) + " " +ip+"\n";
        File file = new File(PropUril.FILEPATH+"//ip.txt");
        if(! file.exists() )
            file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file,true);
        fos.write(ip.getBytes() );
        fos.close();

        return "index";
    }

    String getUserIp(HttpServletRequest request) {
        String ip =request.getHeader("x-forward-for");
        if (ip == null || ip.length()==0)
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) )
        {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
