package controller.cart;

import dao.AutionInfoDAO;
import dao.ShopCartDAO;
import pojo.entity.AutionInfoDo;
import pojo.entity.ShopCartDo;
import pojo.entity.UserDo;
import service.ShopCartService;
import utils.DaoFactory;
import utils.PathConstant;
import utils.ServiceFactory;
import utils.factory.FactoryProducer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cart/addCart")
public class AddCartController extends HttpServlet {


    private AutionInfoDAO autionInfoDAO = (AutionInfoDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.AUTION_INFO_DAO_CLASS_PATH);

    private ShopCartDAO shopCartDAO = (ShopCartDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.SHOPCART_DAO_CLASS_PATH);

    private ShopCartService shopCartService = (ShopCartService) FactoryProducer.getFactory(FactoryProducer.SERVICE_FACTORY)
            .getService(ServiceFactory.SHOPCART_SERVICE_CLASS_PATH);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String autionId = req.getParameter("autionId");

        UserDo userDo = (UserDo) req.getSession().getAttribute("user");

        AutionInfoDo autionInfoDo = null;
        List<ShopCartDo> cartLists = null;
        try {

            autionInfoDo = autionInfoDAO.queryAutionById(autionId);
        } catch (Exception e) {

            e.printStackTrace();

        }

        /**
         * 先判断用户是否登录、
         *      -若登录，直接将购物车中物品存入数据库中
         *      -若未登录，则将购物车物品信息存入session中
         *          -判断session中是否有该物品，
         *              -包含，数量+1，修改session中数据
         *              -不包含，添加到session中
         *          -判断数据库中是否有该数据
         *              -包含，数量+1，修改数据库记录
         *              -不包含，数据库添加一条记录
         */

        if (userDo == null) {

            cartLists = (List<ShopCartDo>) req.getSession().getAttribute("cartlists");


            if (cartLists == null) {

                cartLists = new ArrayList<>();
            }

            //先判断Session中是否含有该对象
            if (shopCartService.judgeIsContains(cartLists, autionId)) {

                /**
                 * 将AutionInfoDo转化为ShopCartDo对象
                 */
                ShopCartDo shopCartDo = shopCartService.transferToShopCartDo(autionInfoDo, userDo, autionId);

                cartLists.add(shopCartDo);

            }

        } else {

            ShopCartDo shopCartDo = null;

            try {

                cartLists = shopCartDAO.selectAllShopCart();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //判断数据库中是否有该对象
            if (shopCartService.judgeIsContains(cartLists, autionId)) {

                /**
                 * 将AutionInfoDo转化为ShopCartDo对象
                 */
                shopCartDo = shopCartService.transferToShopCartDo(autionInfoDo, userDo, autionId);

                try {

                    shopCartDAO.insertShopCart(shopCartDo);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                //存在就修改，更新数据库
                try {

                    shopCartDAO.queryShopCartByAutionId(autionId)
                            .ifPresent(v -> {
                                try {
                                    shopCartDAO.updateShopCartByCartId(v);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            try {

                //更新购物车列表
                cartLists = shopCartDAO.selectAllShopCart();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        req.getSession().setAttribute("cartlists", cartLists);

        req.getRequestDispatcher(PathConstant.SHOPCART_PAYH + "/cartList.jsp").forward(req, resp);

    }
}
