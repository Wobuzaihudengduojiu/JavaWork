package dao;

import pojo.entity.UserDo;

import java.sql.SQLException;

public interface UserDAO extends BaseDAO {


    /**
     * 用于登陆检验
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    UserDo findUser(String username, String password) throws SQLException;


}
