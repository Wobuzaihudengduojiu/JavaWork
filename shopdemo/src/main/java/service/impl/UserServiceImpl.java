package service.impl;

import dao.UserDAO;
import pojo.entity.UserDo;
import service.UserService;
import utils.DaoFactory;
import utils.factory.FactoryProducer;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {


    UserDAO userDAO = (UserDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.USER_DAO_CLASS_PATH);

    @Override
    public String checkParam(UserDo user) {

        String msg = null;

        try {

            if (userDAO.findUser(user.getUserName(), user.getPassword()) == null) {

                msg = "用户名或密码错误";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
