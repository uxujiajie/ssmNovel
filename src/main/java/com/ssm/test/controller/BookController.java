package com.ssm.test.controller;

import com.ssm.test.domain.*;
import com.ssm.test.service.BookService;
import com.ssm.test.service.CategoryService;
import com.ssm.test.util.Image;
import com.ssm.test.util.PropUril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * 书籍
 *
 * @author xu
 * @create 2017-07-24-10:42
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="turnWriterPage_haveUser")
    public String turnWriterPage(HttpSession session, Model model) throws Exception {
        if(false)
            return "turnWriter";        //后期加作家申请

        /**
         * 查询所有写的图书
         */
        UserExam user = (UserExam) session.getAttribute("user");
        BookQueryVo bqv = bookService.findWriterBook(user.getId() );

        model.addAttribute("writerBooks",bqv);
        return "userBook";
    }

    /**
     * 跳转新建书籍页面
     */
    @RequestMapping(value = "turnWriteBook_haveUser")
    public String turnWriteBook(Model model) throws Exception {
        /**
         *  查找所有分类
         */
        List<Category> categoryList =  categoryService.findAllCate();
        model.addAttribute("categoryList", categoryList);
        return "WriteBook";
    }
    /**
     * 新建作品
     */
    @RequestMapping(value="addBook_haveUser")
    public String addBook(Book book, @RequestParam(value="upload") MultipartFile bookimage,Model model,HttpSession session) throws Exception {
        long len = bookimage.getSize();
        if(len >= 100)
        {
            //文件类型
            String contentType = bookimage.getContentType();
            //对文件类型做判断

            //存储图片的根路径
            String root = PropUril.FILEPATH;
            //原始名称
            String original = bookimage.getOriginalFilename();
            String pre = original.substring(original.lastIndexOf("."));
            if(!pre.equalsIgnoreCase(".jpg" )&&! pre.equalsIgnoreCase(".png"))
            {
                model.addAttribute("msg","只支持jpg或png格式的图片");
                return "forward:turnWriteBook_haveUser.action";
            }
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //文件名称
            String fileName = uuid + pre;

            //得到hashcode值目录分级
            int hCode = fileName.hashCode();
            String hex = Integer.toHexString(hCode);
            String fileDirect = hex.charAt(0) +"\\" + hex.charAt(1)
                    + "\\" + fileName;
            //图片文件目录
            File file = new File(root, fileDirect);
            File file1 = new File(root, hex.charAt(0) +"\\" + hex.charAt(1)
                    + "\\" + uuid );
            if(!file1.exists() )
                file1.mkdirs();
            if(!file.exists() )
                file.mkdirs();
            //将内存中的数据写入磁盘
            bookimage.transferTo(file);
            Image image = new Image(file);
            image.resize(800,600);
            image.save();
            book.setBookimage("\\" + fileDirect);
            book.setBookurl(hex.charAt(0) +"\\" + hex.charAt(1)
                    + "\\" + uuid + "\\");
        } else {
            model.addAttribute("msg","必须填充图片哦");
            return "forward:turnWriteBook_haveUser.action";
        }
        bookService.addWriterBook(book);
        return "redirect:turnWriterPage_haveUser.action";
    }

    /**
     * 根据id查找这本书
     */
    @RequestMapping(value="findTheBook/{id}")
    public String findTheBook(Model model, @PathVariable("id") Integer id) throws Exception{
            BookExam book = bookService.findBookById(id);
            model.addAttribute("book", book);
            return "/book";
    }

    /**
     * 查询所有书籍(分页)  页码
     */
    @RequestMapping(value="findAllByPage")
    public String findAllByPage(Integer pc,Integer tr, Model model) throws Exception {
        if(pc == null)
            pc = 1;
        PageBean<Book> pageBean = bookService.findAllBookByPage(pc,tr);
        pageBean.setUrl("findAllByPage");
        model.addAttribute( "pageBean", pageBean);
        return "listBook";
    }
    /**
     * 查询所有书籍(分页)  点击量
     */
    @RequestMapping(value="findAllByPageHits")
    public String findAllByPageHits(Integer pc,Integer tr, Model model) throws Exception {
        if(pc == null)
            pc = 1;
        PageBean<Book> pageBean = bookService.findAllBookByPageHits(pc,tr);
        pageBean.setUrl("findAllByPageHits");
        model.addAttribute( "pageBean", pageBean);
        return "listBook";
    }
    /**
     * 查询所有书籍(分页)  更新
     */
    @RequestMapping(value="findAllByPageUpdate")
    public String findAllByPageUpdate(Integer pc,Integer tr, Model model) throws Exception {
        if(pc == null)
            pc = 1;
        PageBean<Book> pageBean = bookService.findAllBookByUpdate(pc,tr);
        pageBean.setUrl("findAllByPageUpdate");
        model.addAttribute( "pageBean", pageBean);
        return "listBook";
    }
    /**
     * 查询所有书籍(分页)  创建时间
     */
    @RequestMapping(value="findAllByPageCreate")
    public String findAllByPageCreate(Integer pc,Integer tr, Model model) throws Exception {
        if(pc == null)
            pc = 1;
        PageBean<Book> pageBean = bookService.findAllBookByPageCreate(pc,tr);
        pageBean.setUrl("findAllByPageCreate");
        model.addAttribute( "pageBean", pageBean);
        return "listBook";
    }
    /**
     * 根据作者或书名查询    更新时间
     */
    @RequestMapping(value = "findByAuthorOrName")
    public String findByAuthorOrName(String authorOrName, Model model) throws Exception {
        List<Book> bookList = bookService.findByAuthorOrName(authorOrName);
        model.addAttribute("bookList",bookList);
        return "serchBook";
    }

    /**
     * 添加书架
     */
    @RequestMapping(value = "addRack_haveUser/{bookId}")
    public String addRack(@PathVariable("bookId") Integer id, Model model,HttpSession session) throws Exception {
        UserExam user = (UserExam) session.getAttribute("user");
        List<Book> lb = user.getBookList();
        Book b = new Book();
        b.setId(id);
        lb.add(b);
        user.setBookList(lb);
        session.removeAttribute("user");
        session.setAttribute("user", user);
        bookService.addBookRack(user.getId(), id);
        return "redirect:/findTheBook/"+id;
    }

    /**
     * 跳转到写章节页面
     */
    @RequestMapping(value = "turnWriteSec_haveUser/{bookId}")
    public String turnWriteSec(@PathVariable("bookId") Integer id, Model model) throws Exception {
        model.addAttribute("bookId", id);
        return "/WriteSec";
    }


}
