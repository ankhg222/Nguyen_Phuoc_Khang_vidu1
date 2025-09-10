package vn.khang.dao;

import vn.khang.model.User;
import vn.khang.utils.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // ✅ Đăng nhập
    public User login(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractUser(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Tìm user theo id
    public User findById(int id) {
        String sql = "SELECT * FROM Users WHERE id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractUser(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Cập nhật thông tin profile
    public boolean updateProfile(int id, String fullname, String phone, String avatarPath) {
        String sql = "UPDATE Users SET fullname=?, phone=?, avatar=? WHERE id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, fullname);
            ps.setString(2, phone);
            ps.setString(3, avatarPath);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Lấy tất cả user
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection c = DB.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(extractUser(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✅ Thêm user mới
    public boolean insert(User u) {
        String sql = "INSERT INTO Users(email, username, fullname, password, avatar, roleId, phone, createdDate) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, u.getEmail());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getFullname());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getAvatar());
            ps.setInt(6, u.getRoleId());
            ps.setString(7, u.getPhone());
            ps.setDate(8, new java.sql.Date(u.getCreatedDate().getTime()));

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Xóa user
    public boolean delete(int id) {
        String sql = "DELETE FROM Users WHERE id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔹 Hàm private hỗ trợ map ResultSet → User object
    private User extractUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setEmail(rs.getString("email"));
        u.setUsername(rs.getString("username"));
        u.setFullname(rs.getString("fullname"));
        u.setPassword(rs.getString("password"));
        u.setAvatar(rs.getString("avatar"));
        u.setRoleId(rs.getInt("roleId"));
        u.setPhone(rs.getString("phone"));
        u.setCreatedDate(rs.getDate("createdDate"));
        return u;
    }
}
