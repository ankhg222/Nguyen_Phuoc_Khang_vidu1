package vn.iot;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static final String serverName = "localhost"; 
    private static final String dbName = "User";           // ⚠️ đặt lại tên DB cho an toàn (vd: DangNhapDB)
    private static final String portNumber = "1433";
    private static final String instance = ""; 
    private static final String userID = "sa";
    private static final String password = "1";

    public static Connection getConnection() throws Exception {
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
        try (Connection conn = DBConnect.getConnection()) {
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
