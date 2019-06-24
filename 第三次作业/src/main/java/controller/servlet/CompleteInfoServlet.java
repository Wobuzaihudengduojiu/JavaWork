package controller.servlet;

import pojo.entity.param.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet("/completeInfoServlet")
public class CompleteInfoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("utf-8");
        String PATH = req.getContextPath();

        List<String> technology = Arrays.asList(req.getParameterValues("technology"));

        UserDetails user = (UserDetails) req.getSession().getAttribute("userDetails");

        if (user != null) {

            user.setTechnology(technology);

            req.getSession().setAttribute("personInfo",user);

            req.getRequestDispatcher(PATH+"/userInfoShowView").forward(req,resp);
        }else{
            resp.sendRedirect(PATH+"/userInfoView");
        }


    }
}
