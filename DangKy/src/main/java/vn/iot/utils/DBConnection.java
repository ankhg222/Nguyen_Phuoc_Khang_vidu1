package vn.iot.utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String serverName = "localhost"; // hoặc 127.0.0.1
    private final String dbName = "QLTV"; // thay bằng tên CSDL của bạn
    private final String portNumber = "1433";
    private final String instance = ""; // để trống nếu cài SQL mặc định, nếu có instance thì ghi vào (VD: MSSQLSERVER)
    private final String userID = "sa"; // tài khoản SQL Server
    private final String password = "1"; // mật khẩu SQL Server

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber;
        if (instance != null && instance.trim().length() > 0)
            url += ";instance=" + instance;
        url += ";databaseName=" + dbName;
        url += ";encrypt=true;trustServerCertificate=true";  // thêm dòng này

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            Connection conn = new DBConnection().getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}