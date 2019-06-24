package service.impl;

import dao.ShopCartDAO;
import pojo.entity.AutionInfoDo;
import pojo.entity.ShopCartDo;
import pojo.entity.UserDo;
import service.ShopCartService;
import utils.DaoFactory;
import utils.UUIDUtils;
import utils.factory.FactoryProducer;

import java.util.List;

public class ShopCartServiceImpl implements ShopCartService {


    ShopCartDAO shopCartDAO = (ShopCartDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.SHOPCART_DAO_CLASS_PATH);


    @Override
    public ShopCartDo transferToShopCartDo(AutionInfoDo autionInfoDo, UserDo userDo, String autionId) {

        ShopCartDo shopCartDo = null;

        String userId = userDo == null ? null : userDo.getUserId();

        shopCartDo = ShopCartDo.builder()
                .autionId(autionInfoDo.getAutionId())
                .cartId(UUIDUtils.getUUID())
                .cartImage(autionInfoDo.getAutionImage())
                .cartNum(1)
                .cartPrice(autionInfoDo.getAutionPrice())
                .cartProperty(autionInfoDo.getAutionInfo())
                .userId(userId)
                .cartName(autionInfoDo.getAutionName())
                .build();

        return shopCartDo;
    }

    @Override
    public Boolean judgeIsContains(List<ShopCartDo> shopCartDos, String autionId ){


        //判断集合中是否有该对象,有则修改
        int count = (int) shopCartDos.stream()
                .filter(v -> autionId.equals(v.getAutionId()))
                .peek(v -> v.setCartNum(v.getCartNum() + 1))
                .count();

        return count == 0;
    }
}
