package vn.iot.model;



import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private int id;
    private String email, userName, fullName, passWord, avatar, phone;
    private int roleid;
    private Date createdDate;

    // Getters và Setters đầy đủ
    // GETTERS
    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getUserName() { return userName; }
    public String getFullName() { return fullName; }
    public String getPassWord() { return passWord; }
    public String getAvatar() { return avatar; }
    public String getPhone() { return phone; }
    public int getRoleid() { return roleid; }
    public Date getCreatedDate() { return createdDate; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPassWord(String passWord) { this.passWord = passWord; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRoleid(int roleid) { this.roleid = roleid; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
}