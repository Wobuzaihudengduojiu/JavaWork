package dao.impl.instance;

import dao.ShopCartDAO;
import pojo.entity.ShopCartDo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ShopCartDAOImpl implements ShopCartDAO {

    @Override
    public Boolean deleteCartById(String cartId) throws Exception {

        List<ShopCartDo> autionInfoDoList = AutionList.shopCartList;

        Iterator<ShopCartDo> iterator = autionInfoDoList.iterator();

        while (iterator.hasNext()) {

            ShopCartDo shopCartDo = iterator.next();

            if (cartId.equals(shopCartDo.getCartId())) {

                iterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean insertShopCart(ShopCartDo shopCartDo) throws Exception {

        return Optional.ofNullable(shopCartDo)
                .map(v -> {
                    AutionList.shopCartList.add(shopCartDo);
                    return true;
                })
                .orElse(false);

    }

    @Override
    public List<ShopCartDo> selectAllShopCart() throws Exception {

        return AutionList.shopCartList;

    }

    @Override
    public Boolean insertShopCarts(List<ShopCartDo> shopCartDoList) throws Exception {


        return AutionList.shopCartList.addAll(shopCartDoList);
    }


    @Override
    public ShopCartDo queryShopCartByCartId(String cartId) throws Exception {

        return AutionList.shopCartList.stream()
                .filter(v -> cartId.equals(v.getCartId()))
                .collect(Collectors.toList())
                .get(0);

    }


    @Override
    public int updateShopCartByCartId(String cartId) throws Exception {

        int count = (int) AutionList.shopCartList.stream()
                .filter(v -> cartId.equals(v.getCartId()))
                .peek(v -> v.setCartNum(v.getCartNum() + 1))
                .count();

        return count;
    }

    @Override
    public Optional<String> queryShopCartByAutionId(String autionId) throws Exception {

        return AutionList.shopCartList.stream()
                .filter(v->autionId.equals(v.getAutionId()))
                .map(ShopCartDo::getCartId)
                .findFirst();
    }
}
