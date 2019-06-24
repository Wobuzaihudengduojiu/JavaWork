package controller.view;


import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/loginPageView")
public class LoginPageView extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<head><title>登陆界面</title></head>");
        out.println("<body>");

        String msg = (String) req.getAttribute("msg");

        if (StringUtils.isNotEmpty(msg)) {

            out.println("请重新输入:<font color='red'>" + msg + "</font><br/>");
        }

        String body = "<form action=\"/loginPageServlet\" method=\"get\">\n" +
                "        username:<input type=\"text\" name=\"username\"/><br/>\n" +
                "        password:<input type=\"password\" name=\"password\"/><br/>\n" +
                "        <input type=\"submit\" value=\"登录\">\n" +
                "    </form>";

        out.println(body);
        out.println("</body>");
        out.println("</html");
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
