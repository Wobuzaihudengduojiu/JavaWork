package pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDo {

    //用户id
    private String userId;

    //用户名
    private String userName;

    //密码
    private String password;

    //用户余额
    private Double balance;

    //头像
    private String image;

}


