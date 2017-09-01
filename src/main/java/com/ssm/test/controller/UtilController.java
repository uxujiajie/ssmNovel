package com.ssm.test.controller;

import com.test.verify.Verify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 工具类使用controller
 *
 * @author xu
 * @create 2017-07-23-15:50
 */
@Controller
public class UtilController {

    @RequestMapping("checkImg")
    public void checkImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Verify vv = new Verify();
        BufferedImage bi = vv.getImage();
        String code = vv.getText();

         request.getSession().setAttribute("checkcode", code);
        ImageIO.write(bi, "jpg", response.getOutputStream() );
    }
}
