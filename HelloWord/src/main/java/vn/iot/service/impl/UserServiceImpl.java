package vn.iot.service.impl;


import vn.iot.dao.UserDao;
import vn.iot.dao.impl.UserDaoImpl;
import vn.iot.model.User;
import vn.iot.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        User user = userDao.get(username);
        if (user != null && password.equals(user.getPassWord())) return user;
        return null;
    }
}