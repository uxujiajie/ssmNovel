package com.ssm.test.controller;

import com.ssm.test.domain.User;
import com.ssm.test.domain.UserExam;
import com.ssm.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户crotroller
 *
 * @author xu
 * @create 2017-07-23-15:41
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "userLoginPage")
    public String userLoginPage() throws Exception {
        return "login";
    }
    /**
     * 跳转注册页面
     */
    @RequestMapping(value="userRegistPage")
    public String userRegistPage() throws Exception {
        return "regist";
    }

    /**
     * 注册
     */
    @RequestMapping(value="userRegist",method = {RequestMethod.POST})
    public String userRegist(User user, String checkCode, HttpSession session, Model model,HttpServletRequest request) throws  Exception {
        if(!session.getAttribute("checkcode").toString().equalsIgnoreCase(checkCode) )
        {
            model.addAttribute("msg", "验证码错误");
            return "regist";
        }
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        userService.registUser(user,basePath);
        model.addAttribute("msg","激活后登录");
        return "login";
    }

    /**
     * 验证用户名
     */
    @RequestMapping(value = "valiUsername")
    public void valiUsername(HttpServletRequest request, HttpServletResponse response,User user1)
        throws Exception {
        User user = userService.findUserByName(user1.getUserName());
        response.setCharacterEncoding("utf-8");
        if(user == null)
            response.getWriter().print("用户名可用");
        else
            response.getWriter().print("用户名已被使用");

    }

    /**
     * 激活用户
     */
    @RequestMapping(value="activeUser")
    public String activeUser(String userAcode) throws Exception {
        userService.activeUser(userAcode);
        return "login";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "loginUser")
    public  String loginUser(User user,HttpSession session, Model model) throws  Exception {
        UserExam loginUser = userService.loginUser(user);
        if(loginUser == null)
        {
            model.addAttribute("msg","用户不存在或密码错");
            return "login";
        } else {
            session.setAttribute("user",loginUser);
        }

        return "redirect:turnIndex";
    }

    /**
     * 跳转到书架页面
     */
    @RequestMapping(value = "turnUserRack_haveUser")
    public String turnUserRack()  throws Exception {
        return "userRock";
    }

    /**
     * 注销
     */
    @RequestMapping(value="logoutUser")
    public  String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:turnIndex.action";
    }

    /**
     * 用户信息界面
     */
    @RequestMapping(value="UserInfo")
    public String UserInfo() throws Exception {
        return "userInfo";
    }

    /**
     * 用户删除书架
     */
    @RequestMapping(value = "deleteRack")
    public String deleteRack(Integer[] bookIds ,HttpSession  session, Model model) {
        UserExam userExam = (UserExam) session.getAttribute("user");
        if(userExam == null)
        {
            model.addAttribute("msg","请登录后查看");
            return "msg";
        }
        userService.deleteRacks(userExam.getId(), bookIds);
        return "redirect:turnUserRack.action";
    }
}
