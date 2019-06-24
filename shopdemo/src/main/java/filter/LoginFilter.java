package filter;

import dao.ShopCartDAO;
import pojo.entity.ShopCartDo;
import utils.DaoFactory;
import utils.factory.FactoryProducer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginFilter implements Filter {

    ShopCartDAO shopCartDAO = (ShopCartDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.SHOPCART_DAO_CLASS_PATH);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        /**
         * 用户在登录时，将session中临时的购物车信息持久化到数据库中
         */

        List<ShopCartDo> shopCartDoListInSession = (List<ShopCartDo>) req.getSession().getAttribute("cartlists");

        boolean flag = false;

        try {

            flag = shopCartDAO.insertShopCarts(shopCartDoListInSession);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag) {

            System.out.println("拦截成功");

            filterChain.doFilter(req, resp);
        }
    }
}
