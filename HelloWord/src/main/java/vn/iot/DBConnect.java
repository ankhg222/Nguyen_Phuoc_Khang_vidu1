package vn.iot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
    private final String serverName = "DESKTOP-U99VI3O"; // hoặc IP
    private final String dbName = "LTWEB";
    private final String portNumber = "1433";
    private final String instance = ""; // nếu có instance: "SQLEXPRESS"
    private final String userID = "sa";
    private final String password = "1";

    public Connection getConnection() throws Exception {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=false;trustServerCertificate=true";
        } else {
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=false;trustServerCertificate=true";
        }

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        String sqlInsert = "INSERT INTO users VALUES(?, ?, ?)";
        String selectAll = "SELECT * FROM users";

        try (Connection conn = new DBConnect().getConnection()) {
            // Insert dữ liệu
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setInt(1,7);
            stmt.setString(2, "Thắng");
            stmt.setString(3, "yêu Sang ");
            stmt.execute();
            stmt.close();

            // Lấy tất cả dữ liệu
            stmt = conn.prepareStatement(selectAll);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}