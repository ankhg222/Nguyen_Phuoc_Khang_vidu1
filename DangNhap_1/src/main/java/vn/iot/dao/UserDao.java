package vn.iot.dao;

import vn.iot.model.User;

public interface UserDao {
    User get(String username, String password);
    User findByUsernameAndEmail(String username, String email);
    boolean updatePasswordByUsername(String username, String newPassword);
    void insert(User user);
}
