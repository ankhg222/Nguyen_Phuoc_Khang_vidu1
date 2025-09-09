package vn.iot.dao.impl;

import vn.iot.dao.CategoryDao;
import vn.iot.model.Category;
import vn.iot.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends DBConnect implements CategoryDao {

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category(cate_name, icons, user_id) VALUES (?, ?, ?)";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category.getCateName());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Category SET cate_name=?, icons=? WHERE cate_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category.getCateName());
            ps.setString(2, category.getIcon());
            ps.setInt(3, category.getCateId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE cate_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM Category WHERE cate_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setCateId(rs.getInt("cate_id"));
                c.setCateName(rs.getString("cate_name"));
                c.setIcon(rs.getString("icons"));
                c.setUserId(rs.getInt("user_id"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> getAllByUser(int userId) {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category WHERE user_id=?";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCateId(rs.getInt("cate_id"));
                c.setCateName(rs.getString("cate_name"));
                c.setIcon(rs.getString("icons"));
                c.setUserId(rs.getInt("user_id"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try (Connection con = super.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Category c = new Category();
                c.setCateId(rs.getInt("cate_id"));
                c.setCateName(rs.getString("cate_name"));
                c.setIcon(rs.getString("icons"));
                c.setUserId(rs.getInt("user_id"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
