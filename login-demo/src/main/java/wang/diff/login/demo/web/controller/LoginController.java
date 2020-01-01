package wang.diff.login.demo.web.controller;

import wang.diff.login.demo.entity.User;
import wang.diff.login.demo.service.UserService;
import wang.diff.login.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录控制器
 */
public class LoginController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("loginId");
        String loginPwd = req.getParameter("loginPwd");

        User user = userService.login(loginId, loginPwd);

        // 登录失败的处理
        if ( null  == user) {
            req.getRequestDispatcher("/fail.jsp").forward(req, resp);
        }
        //登陆成功的处理
        else {
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        }


    }
}
