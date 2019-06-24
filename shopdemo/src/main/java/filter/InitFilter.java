package filter;

import dao.AutionTypeDAO;
import dao.impl.instance.AutionList;
import pojo.entity.AutionInfoDo;
import pojo.entity.AutionTypeDo;
import utils.DaoFactory;
import utils.factory.FactoryProducer;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * 项目启动时，加载首页和类目信息
 */

public class InitFilter implements Filter {


    AutionTypeDAO autionTypeDAO= (AutionTypeDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.AUTION_TYPE_DAO_CLASS_PATH);



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


        ServletContext application=filterConfig.getServletContext();

        //类目信息
        List<AutionTypeDo> autionTypeDoList=autionTypeDAO.selectAllAutionType();

        application.setAttribute("autionTypeDoList",autionTypeDoList);

        //商品信息
        List<AutionInfoDo> autionInfoDoList= AutionList.list;
        application.setAttribute("autionInfoDoList",autionInfoDoList);

        System.out.println("页面初始化成功");

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


    }
}
