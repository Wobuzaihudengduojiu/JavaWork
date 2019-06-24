package controller.aution;


import dao.AutionInfoDAO;
import pojo.entity.AutionInfoDo;
import service.AutionInfoService;
import utils.DaoFactory;
import utils.PathConstant;
import utils.ServiceFactory;
import utils.StringUtils;
import utils.factory.FactoryProducer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/autionInfo")
public class AutionInfoController extends HttpServlet {


    private AutionInfoDAO autionInfoDAO = (AutionInfoDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.AUTION_INFO_DAO_CLASS_PATH);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String PATH=req.getContextPath();

        String autionId = req.getParameter("autionId");

        AutionInfoDo autionInfo = null;

        if (!StringUtils.isEmpty(autionId)) {

            try {

                autionInfo = autionInfoDAO.queryAutionById(autionId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        req.setAttribute("autionInfo",autionInfo);

        req.getRequestDispatcher(PATH+ PathConstant.AUTION_PATH+"/autionInfo.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);

    }
}
