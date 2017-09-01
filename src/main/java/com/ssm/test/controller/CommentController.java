package com.ssm.test.controller;

import com.ssm.test.domain.Comment;
import com.ssm.test.domain.UserExam;
import com.ssm.test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 评论前台
 *
 * @author xu
 * @create 2017-07-30-18:43
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 用户查询个人信息，带评论
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "userLookComment")
    public String userLookComment(HttpSession session, Model model) throws Exception {
        UserExam userExam = (UserExam) session.getAttribute("user");
        model.addAttribute("userComment", commentService.userLookComment(userExam.getId() ) );
        return "userInfo";
    }

    /**
     * 用户发表评论
     */
    @RequestMapping(value = "addCommentByUser")
    public void addCommentByUser(Comment comment, HttpSession session, Model model, HttpServletResponse response) throws Exception {
            UserExam userExam = (UserExam) session.getAttribute("user");
            response.setCharacterEncoding("utf-8");
            if(userExam == null)
            {
                response.getWriter().print("您还未登录，请登录");
            }
            comment.setUserid(userExam.getId() );
            commentService.addCommentByUser(comment);
            response.getWriter().print("发表成功，刷新后查看");
    }
}
