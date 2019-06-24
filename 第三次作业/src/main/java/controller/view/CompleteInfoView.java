package controller.view;


import pojo.entity.User;
import pojo.entity.param.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/completeInfoView")
public class CompleteInfoView extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String PATH=req.getContextPath();

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User user=(User)req.getSession().getAttribute("user");
        if(user==null){

            PATH=PATH+"/loginPageView";
            String msg="尚未登陆";
            resp.sendRedirect(PATH+"?msg="+msg);
        }else {

            PrintWriter out = resp.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<head><title>完善个人信息</title></head>");
            out.println("<body>");
            out.println("当前登陆的用户:" + user.getName());

            String body="<form action=\"/completeInfoServlet\" method=\"post\">\n" +
                    "        擅长技术:\n" +
                    "        <input type=\"checkbox\" name=\"technology\" value=\"Java\">Java\n" +
                    "        <input type=\"checkbox\" name=\"technology\" value=\"C#\">C#\n" +
                    "        <input type=\"checkbox\" name=\"technology\" value=\"android\">android<br/>\n" +
                    "        <input type=\"submit\" value=\"完成\">\n" +
                    "    </form>";


            out.println(body);

            out.println("</body>");
            out.println("</html");

            out.flush();
            out.close();

        }
    }
}
