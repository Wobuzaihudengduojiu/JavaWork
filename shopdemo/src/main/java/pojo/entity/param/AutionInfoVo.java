package pojo.entity.param;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AutionInfoVo {

    //商品id
    private String autionId;

    //商品属性
    private String autionProperty;

    //商品价格
    private double autionPrice;

    //商品名称
    private String autionName;

    //商品描述
    private String autionInfo;

    //商品图片
    private String autionImage;




}
