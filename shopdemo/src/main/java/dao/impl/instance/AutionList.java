package dao.impl.instance;

import pojo.entity.AutionInfoDo;
import pojo.entity.ShopCartDo;
import utils.UUIDUtils;

import java.util.ArrayList;
import java.util.List;

public class AutionList {


    public static List<AutionInfoDo> list= new ArrayList<>();

    public static List<ShopCartDo> shopCartList= new ArrayList<>();

    static {

        for(int i=0;i<12;i++){

            AutionInfoDo autionTypeDo = AutionInfoDo.builder()
                    .autionId(UUIDUtils.getUUID())
                    .autionName("商品"+i)
                    .autionInfo("商品描述")
                    .autionPrice(150+i)
                    .build();

            list.add(autionTypeDo);
        }





    }



}
