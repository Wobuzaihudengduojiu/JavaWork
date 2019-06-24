package controller;

import dao.impl.instance.AutionList;
import pojo.entity.AutionInfoDo;
import pojo.entity.UserDo;
import service.UserService;
import utils.factory.FactoryProducer;
import utils.ServiceFactory;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {


    private UserService userService=(UserService) FactoryProducer.getFactory(FactoryProducer.SERVICE_FACTORY)
            .getService(ServiceFactory.USER_SERVICE_CLASS_PATH);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String PATH = req.getContextPath();

        // 如果cookie中包含username则直接登陆
        Arrays.stream(req.getCookies())
                .filter(v -> "username".equals(v.getName()))
                .peek(
                        v -> {
                    try {
                        req.getRequestDispatcher(req.getContextPath() + "/index.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).collect(Collectors.toList());

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDo user = UserDo.builder()
                .userId(UUIDUtils.getUUID())
                .userName(username)
                .password(password)
                .build();

       // String msg = userService.checkParam(user);

        //if (msg == null) {

            //将获取的信息存储到session中
            req.getSession().setAttribute("user", user);

            //将用户信息存到cookie中
            Cookie cookieName = new Cookie("username", username);
            cookieName.setMaxAge(10);
            resp.addCookie(cookieName);


            //商品信息
//        List<AutionInfoDo> autionInfoDoList= AutionList.list;
//        req.setAttribute("autionInfoDoList",autionInfoDoList);


            PATH = PATH + "/index.jsp";
      //  } else {

            //登陆失败，返回到首页
           // PATH = PATH + "/login.jsp";
          //  req.setAttribute("msg", msg);
        //}

        req.getRequestDispatcher(PATH).forward(req, resp);
    }
}
