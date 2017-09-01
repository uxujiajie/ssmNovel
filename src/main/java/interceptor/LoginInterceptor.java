package interceptor;

import com.ssm.test.domain.UserExam;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.System.out;

/**
 * 用户拦截器，部分页面必须登录才能进入
 *
 * @author xu
 * @create 2017-08-01-10:34
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws ServletException, IOException {
        out.println("==============执行顺序: 1、preHandle================");
        String requestUri = request.getRequestURI();
        String contextPath =  request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        out.println("requestUri" + requestUri);
        out.println("contextPath" + contextPath);
        out.println("url" + url);
        if(url.contains("haveUser") )
        {
            UserExam user = (UserExam) request.getSession().getAttribute("user");
            if(user == null)
            {
                request.setAttribute("msg","請登陸后操作");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
                return false;
            }
        }
        return true;
    }
}
