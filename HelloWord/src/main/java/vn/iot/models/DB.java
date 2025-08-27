package vn.iot.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL =
        "jdbc:sqlserver://localhost:1433;databaseName=HelloWord;encrypt=false;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "1";

    static {
        try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); }
        catch (ClassNotFoundException e) { throw new RuntimeException(e); }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}