package service;

import pojo.entity.User;

public interface LoginService {

    /**
     * 登陆参数检验，
     */
    String checkParam(User user);

}
