package com.ssm.test.util;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;

/**
 * 测试图像工具类
 *
 * @author xu
 * @create 2017-08-06-10:17
 */
public class TestImageUtil {

    public static void main(String[] args){
        Image image = new Image("D://picUseAll//微笑狗.jpg");
        image.resize(300,200);
        File file = new File("D://picUseAll//微笑狗_300X200.jpg");
        image.saveAs("D://picUseAll//微笑狗_300X200.jpg");

        GenericServlet gs = new GenericServlet() {
            @Override
            public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

            }
        };
        //HttpServlet
    }

}
