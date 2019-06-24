package controller.view;

import pojo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/indexView")
public class IndexView extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String PATH = req.getContextPath();

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {

            PATH = PATH + "/loginPageView";
            String msg = "尚未登陆";
            resp.sendRedirect(PATH + "?msg=" + msg);
        } else {

            PrintWriter out = resp.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<head><title>登陆界面</title></head>");
            out.println("<body>");
            out.println("当前登陆的用户:" + user.getName());

            out.println("<a href='/indexView'>进入首页</a><br/>");
            out.println("<a href='/userInfoServlet'>完善个人信息</a><br/>");

            out.println("</body>");
            out.println("</html");

            out.flush();
            out.close();

        }


    }
}
