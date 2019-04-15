package service.impl;

import pojo.entity.User;
import service.LoginService;

public class LoginServiceimpl implements LoginService {


    @Override
    public String checkParam(User user) {

        String msg = null;

        if (user.getName() == null || "".equals(user.getName().trim())
                || user.getPassword() == null || "".equals(user.getPassword().trim())) {

            msg = "用户名或者密码不能为空";
        }

        return msg;
    }
}
