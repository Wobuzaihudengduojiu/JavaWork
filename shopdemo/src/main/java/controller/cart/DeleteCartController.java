package controller.cart;


import dao.ShopCartDAO;
import pojo.entity.ShopCartDo;
import pojo.entity.UserDo;
import utils.DaoFactory;
import utils.PathConstant;
import utils.factory.FactoryProducer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/cart/deleteCart")
public class DeleteCartController extends HttpServlet {


    private ShopCartDAO shopCartDAO = (ShopCartDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.SHOPCART_DAO_CLASS_PATH);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cartId = req.getParameter("cartId");


        UserDo userDo = (UserDo) req.getSession().getAttribute("user");

        List<ShopCartDo> cartLists = null;

        /**
         * 判断用户登录状态、
         *      -未登录：从session中删除购物车信息
         *      -已登录：从数据库中删除购物车信息
         */

        if (userDo == null) {

            cartLists = (List<ShopCartDo>) req.getSession().getAttribute("cartlists");

            System.out.println(cartLists.toString());

            Iterator iterator = cartLists.iterator();

            while (iterator.hasNext()) {

                ShopCartDo shopCartDos = (ShopCartDo) iterator.next();

                if (cartId.equals(shopCartDos.getCartId())) {

                    iterator.remove();
                }

            }

        } else {

            try {

                //从数据库中删除
                shopCartDAO.deleteCartById(cartId);

                cartLists = shopCartDAO.selectAllShopCart();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        req.getSession().setAttribute("cartlists", cartLists);

        req.getRequestDispatcher(PathConstant.SHOPCART_PAYH + "/cartList.jsp").forward(req, resp);

    }
}
