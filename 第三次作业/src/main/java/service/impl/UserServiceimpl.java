package service.impl;

import org.apache.commons.lang.StringUtils;
import service.UserService;

public class UserServiceimpl implements UserService {


    @Override
    public String checkParam(String name, String id, String schoolName, String professior) {

        String msg = null;

        if (!StringUtils.isNotEmpty(name) || !StringUtils.isNotEmpty(id)
                || !StringUtils.isNotEmpty(schoolName)
                || !StringUtils.isNotEmpty(professior)) {
            msg = "请将个人信息补充完整";
        }

        return msg;

    }
}
