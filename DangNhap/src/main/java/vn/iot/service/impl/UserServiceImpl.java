package vn.iot.service.impl;

import vn.iot.dao.UserDao;
import vn.iot.dao.impl.UserDaoImpl;
import vn.iot.model.User;
import vn.iot.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.get(username, password);
    }

    @Override
    public User findByUsernameAndEmail(String username, String email) {
        return userDao.findByUsernameAndEmail(username, email);
    }

    @Override
    public boolean updatePasswordByUsername(String username, String newPassword) {
        return userDao.updatePasswordByUsername(username, newPassword);
    }
    @Override
    public void register(User user) {
        // Gọi DAO để insert user
        userDao.insert(user);
    }
}
