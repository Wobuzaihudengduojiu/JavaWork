package pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopCartDo {

    //id
    private String cartId;

    //商品id
    private String autionId;

    //用户id
    private String userId;

    //图片
    private String cartImage;

    //名称
    private String cartName;

    //属性
    private String cartProperty;

    //价格
    private Double cartPrice;

    //数量
    private Integer cartNum;
}
