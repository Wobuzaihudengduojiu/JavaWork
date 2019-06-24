package pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDo {

    //订单id
    private String orderId;

    //商品id
    private String autionId;

    //用户id
    private String userId;

    //收货地址
    private String address;

    //订单状态
    private Integer orderStatus;

    //支付状态
    private Integer orderPayStatus;

    //联系电话
    private String orderTel;

    //价格
    private Double orderPrice;

    //创建时间
    private Date creatTime;

    //更新时间
    private Date updateTime;

}
