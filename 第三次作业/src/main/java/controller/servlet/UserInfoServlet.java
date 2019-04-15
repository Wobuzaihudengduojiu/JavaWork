package controller.servlet;


import pojo.entity.param.UserDetails;
import service.UserService;
import service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userInfoServlet")
public class UserInfoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String PATH=req.getContextPath();

        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String schoolName = req.getParameter("schoolName");
        String professior = req.getParameter("professior");

        UserService userService = new UserServiceimpl();

        //检验参数
        String msg = userService.checkParam(name, id, schoolName, professior);

        if (msg == null) {

            UserDetails userDetails = new UserDetails();

            userDetails.setId(id)
                    .setName(name)
                    .setProfessior(professior)
                    .setSchoolName(schoolName);

            req.getSession().setAttribute("userDetails",userDetails);

            req.getRequestDispatcher(PATH+"/completeInfoView").forward(req,resp);

        }else {
            resp.sendRedirect(PATH+"/userInfoView?msg="+msg);
        }
    }
}
