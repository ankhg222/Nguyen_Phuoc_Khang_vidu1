package vn.iot.service;

import vn.iot.model.User;

public interface UserService {
    User login(String username, String password);

    // thêm mới cho forgot password
    User findByUsername(String username);
    boolean updatePassword(String username, String newPassword);
}
