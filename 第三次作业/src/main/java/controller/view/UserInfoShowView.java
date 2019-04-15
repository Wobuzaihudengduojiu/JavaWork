package controller.view;

import pojo.entity.param.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/userInfoShowView")
public class UserInfoShowView extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String PATH=req.getContextPath();

        UserDetails user =(UserDetails)req.getSession().getAttribute("personInfo");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>个人信息显示</title></head>");
        out.println("<body>");

        out.println("姓名："+user.getName()+"</br>");
        out.println("学号："+user.getId()+"</br>");
        out.println("学校名称："+user.getSchoolName()+"</br>");
        out.println("专业："+user.getProfessior()+"</br>");
        out.println("擅长技术："+user.getTechnology()+"</br>");

        out.println("<a href='/indexView'>回到首页</a><br/>");

        out.println("</body>");
        out.println("</html");

        out.flush();
        out.close();

    }
}
