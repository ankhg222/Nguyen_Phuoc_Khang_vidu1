package vn.iot.service.impl;

import vn.iot.dao.UserDao;
import vn.iot.dao.impl.UserDaoImpl;
import vn.iot.model.User;
import vn.iot.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        User user = new User(0, email, username, fullname, password, null, 5, phone, date);
        return userDao.insert(user);   // trả về true/false thực sự từ DAO
    }

    @Override
    public boolean checkExistEmail(String email) { return userDao.checkExistEmail(email); }

    @Override
    public boolean checkExistUsername(String username) { return userDao.checkExistUsername(username); }

    @Override
    public boolean checkExistPhone(String phone) { return userDao.checkExistPhone(phone); }

    @Override
    public void insert(User user) { userDao.insert(user); }
}