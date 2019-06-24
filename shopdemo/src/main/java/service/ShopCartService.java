package service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pojo.entity.AutionInfoDo;
import pojo.entity.ShopCartDo;
import pojo.entity.UserDo;

import java.util.List;

public interface ShopCartService extends BaseService {


    /**
     * 将AutionInfoDo对象转换为ShopCartDo对象
     */
    ShopCartDo transferToShopCartDo(AutionInfoDo autionInfoDo, UserDo userDo,String autionId);


    /**
     * 判断购物车中是否有该对象
     */
    Boolean judgeIsContains(List<ShopCartDo> shopCartDos,String autionId);

}
