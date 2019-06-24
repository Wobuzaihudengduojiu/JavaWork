package service;

import pojo.entity.UserDo;

public interface UserService extends BaseService{

    /**
     * 登陆参数检验，
     */
    String checkParam(UserDo user);

}
