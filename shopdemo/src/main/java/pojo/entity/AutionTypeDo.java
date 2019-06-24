package pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AutionTypeDo {

    //类目id
    private Integer typeId;

    //类目名称
    private String typeName;

    //是否有子类目
    private Integer typeHasChild;

    //根类目id
    private Integer typeRootId;

    //商品基本属性
    private String typeInfo;




}
