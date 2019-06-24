package dao.impl.instance;

import dao.UserDAO;
import pojo.entity.UserDo;

import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public UserDo findUser(String username, String password) throws SQLException {
        return null;
    }
}
