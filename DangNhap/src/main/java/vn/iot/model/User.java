package vn.iot.model;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private int id;
    private String email;
    private String username;
    private String fullname;
    private String password;
    private String avatar;
    private String phone;
    private int roleid;
    private Date createdDate;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    // GETTERS
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhone() {
        return phone;
    }

    public int getRoleid() {
        return roleid;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
