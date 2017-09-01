package com.ssm.test.controller;

import com.ssm.test.domain.Admin;
import com.ssm.test.domain.BookExam;
import com.ssm.test.service.AdminService;
import com.ssm.test.service.BookService;
import com.ssm.test.util.PropUril;
import com.ssm.test.util.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xu
 * @create 2017-08-01-20:33
 */
@Controller
public class AdminController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AdminService adminService;

    private static HashMap<String,Integer> adErrorLogin = new HashMap<String, Integer>();

    @RequestMapping(value = "uploadNovel")
    public String uploadNovel(Integer bookId,String pattern,@RequestParam("novel") MultipartFile novelFile) throws Exception {
        /**
         * 查询书的地址
         */
        BookExam book = bookService.findBookById(bookId);
        if(novelFile.getSize() > 100)
        {
            File file= new File(PropUril.FILEPATH+"\\"+book.getBookurl() + book.getBookname()+"_副本.txt");
            File zipFile= new File(PropUril.FILEPATH+"\\"+book.getBookurl() + "sayNovel.zip");
            if(!file.exists() )
                file.createNewFile();
            novelFile.transferTo(file);
            ZipUtil.zipCompress(file, zipFile);
        }
        if(pattern == null || pattern.equals("") )
            pattern = "^.*第.*章\\s+.*$";
        adminService.uploadNovel(book,pattern);
        return "redirect:turnIndex.action";
    }

    /**
     * 验证是否匹配规则
     */
    @RequestMapping(value="validateSec")
    public void validateSec(String pattern, String context, HttpServletResponse response) throws Exception {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(context);

        response.setCharacterEncoding("utf-8");
        if(m.matches() )
        {
            response.getWriter().println("验证通过");
        } else {
            response.getWriter().println("验证失败，请重新定义规则");
        }
    }

    /**
     * 跳转管理员界面
     */
    @RequestMapping(value="turnAdminPage")
    public String turnAdminPage() throws Exception {
        return "/admin/uploadNovel";
    }

    /**
     * 查询所有分类
     */

    /**
     * 管理员登录
     */
    @RequestMapping(value="loginAdmin")
    public String loginUser(Admin admin, HttpServletRequest request) throws  Exception {
        Admin loginAdmin = adminService.loginAdmin(admin);
        if(adErrorLogin.containsKey(getUserIp(request) ) &&  adErrorLogin.get(getUserIp(request) ) > 5)
            return "msg";
        if(loginAdmin != null )
        {
            request.getSession().setAttribute("admin", loginAdmin);
            return "/admin/uploadNovel";
        }
        if (adErrorLogin.containsKey(getUserIp(request) ) )
            adErrorLogin.put(getUserIp(request), adErrorLogin.get(getUserIp(request) )+1);
        else
            adErrorLogin.put(getUserIp(request), 1);
        return "msg";
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
