package dao;

import pojo.entity.ShopCartDo;

import java.util.List;
import java.util.Optional;

public interface ShopCartDAO extends BaseDAO {


    /**
     * 通过商品id删除购物车商品
     */
    Boolean deleteCartById(String cartId) throws Exception;

    /**
     * 插入商品
     */
    Boolean insertShopCart(ShopCartDo shopCartDo) throws Exception;

    /**
     * 获取所有购物车记录
     */
    List<ShopCartDo> selectAllShopCart() throws Exception;

    /**
     * 批量插入
     */
    Boolean insertShopCarts(List<ShopCartDo> shopCartDoList) throws Exception;

    /**
     * 根据商品id查询购物车中的信息
     */
    ShopCartDo queryShopCartByCartId(String cartId) throws Exception;

    /**
     * 根据cartId修改购物车中商品信息
     */
    int updateShopCartByCartId(String cartId) throws Exception;

    /**
     * 通过商品id获取购物车id
     */
    Optional<String> queryShopCartByAutionId(String autionId) throws Exception;


}
