package controller.servlet;

import pojo.entity.User;
import service.impl.LoginServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( urlPatterns = "/loginPageServlet")
public class LoginPageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String PATH=req.getContextPath();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username, password);

        //检验登陆参数
        LoginServiceimpl loginServiceimpl = new LoginServiceimpl();

        String msg = loginServiceimpl.checkParam(user);

        if (msg == null) {

            //将获取的信息存储到session中
            req.getSession().setAttribute("user", user);
            PATH=PATH+"/indexView";
        } else {
            //登陆失败，返回到首页
            PATH= PATH+"/loginPageView";
            req.setAttribute("msg",msg);
        }

        req.getRequestDispatcher(PATH).forward(req,resp);
    }
}
