package vn.iot.dao.impl;


import java.sql.*;
import vn.iot.DBConnect;
import vn.iot.dao.UserDao;
import vn.iot.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [User] WHERE username=?";
        try (Connection conn = new DBConnect().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassWord(rs.getString("password"));
                u.setRoleid(rs.getInt("roleid"));
                return u;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}