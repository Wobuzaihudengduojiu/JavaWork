package controller.view;

import pojo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/userInfoView")
public class UserInfoView extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getContextPath();

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>完善个人信息</title></head>");
        out.println("<body>");
        out.println("当前登陆的用户:" + user.getName());

        String body = "    <form action=\"/userInfoServlet\" method=\"post\">\n" +
                "        姓名:<input type=\"text\" name=\"name\"/><br/>\n" +
                "        学号:<input type=\"text\" name=\"id\"/><br/>\n" +
                "        学校名称:<input type=\"text\" name=\"schoolName\"/><br/>\n" +
                "        专业方向:\n" +
                "        <input type=\"radio\" name=\"professior\" value=\"大数据方向\">大数据方向\n" +
                "        <input type=\"radio\" name=\"professior\" value=\"金融管理\">金融管理\n" +
                "        <input type=\"radio\" name=\"professior\" value=\"软件工程\">软件工程\n" +
                "        <input type=\"submit\" value=\"下一步\">\n" +
                "    </form>";

        out.println(body);
        out.println("</body>");
        out.println("</html");

        out.flush();
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
