package com.ssm.test.controller;

import com.ssm.test.domain.Section;
import com.ssm.test.domain.UserExam;
import com.ssm.test.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 章节Controller
 *
 * @author xu
 * @create 2017-07-27-15:03
 */
@Controller
public class SecController {

    @Autowired
    private SectionService sectionService;

    /**
     * 上传章节
     * @param bookContent
     * @param section
     * @return
     * @throws Exception
     */
    @RequestMapping(value="writeSec_haveUser")
    public String writeSec(@RequestParam("bookContent") String bookContent, Section section, HttpSession session) throws  Exception {
        UserExam userExam = (UserExam) session.getAttribute("user");
        sectionService.uploadSection(bookContent, section, userExam.getId());
        return "index";     //返回查看小说章节的页面
    }

    /**
     * 查看章节内容
     */
    @RequestMapping(value="lookSecContent")
    public String lookSecContent(Integer bookId, Integer secNumId,Model model) throws  Exception {
        model.addAttribute("secExam", sectionService.lookSecContent(bookId, secNumId) );
        return "novelSec";
    }

    /**
     * 查看所有章节
     */
}
