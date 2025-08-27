package vn.iot.ketnoisql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQL {
    private final String serverName = "localhost"; // hoặc IP
    private final String dbName = "Chuong2";
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
    	String sqlInsert = "INSERT INTO Users(username, email, phone, password, address) VALUES(?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM Users";

        try (Connection conn = new SQL().getConnection()) {

        	
        	try (PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {
        	    stmt.setString(1, "Trung");
        	    stmt.setString(2, "trung@gmail.com");
        	    stmt.setString(3, "0901234567");
        	    stmt.setString(4, "123456");
        	    stmt.setString(5, "HCM");
        	    stmt.executeUpdate();
        	}

            try (PreparedStatement stmt = conn.prepareStatement(selectAll);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " "
                            + rs.getString(2) + " "
                            + rs.getString(3));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
