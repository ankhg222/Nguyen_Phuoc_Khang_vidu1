package vn.iot.dao;

import vn.iot.model.User;

public interface UserDao {
    boolean insert(User user);   // trả về true nếu insert thành công
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}