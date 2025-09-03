package vn.iot.dao;

import vn.iot.model.User;

public interface UserDao {
    User get(String username, String password);

    // thêm mới
    User findByUsername(String username);
    boolean updatePassword(String username, String newPassword);
}
