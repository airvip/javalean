package wang.diff.my.shop.web.controller;

import org.apache.commons.lang3.StringUtils;
import wang.diff.my.shop.commons.context.SpringContext;
import wang.diff.my.shop.commons.utils.CookieUtils;
import wang.diff.my.shop.entity.User;
import wang.diff.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// all ok

public class LoginController extends HttpServlet {
    private  static final String COOKIE_NAME_USER_INFO = "userInfo";

//    private UserService userService =  SpringContext.getBean(UserServiceImpl.class);
    private UserService userService =  SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);
        if(!StringUtils.isBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("isRemember", true);
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Boolean isRemember = req.getParameter("isRemember") == null ? false : true;

        if(!isRemember) {
            CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
        }

        User admin = userService.login(email, password);
        if(null != admin)
        {
            if (isRemember) {
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 86400);
            }
            resp.sendRedirect("/main.jsp");
        }
        else
        {
            req.setAttribute("message", "用户名或者密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
