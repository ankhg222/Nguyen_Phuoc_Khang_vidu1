package vn.iot.service;

import vn.iot.model.User;

public interface UserService {
    User login(String username, String password);
}