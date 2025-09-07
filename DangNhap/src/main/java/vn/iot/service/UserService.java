package vn.iot.service;

import vn.iot.model.User;

public interface UserService {
    User login(String username, String password);
    User findByUsernameAndEmail(String username, String email);
    boolean updatePasswordByUsername(String username, String newPassword);
}
