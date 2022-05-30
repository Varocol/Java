package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static String url = "jdbc:mysql://localhost:3306/图书借阅管理系统?autoReconnect=true";
    static String user = "root";
    static String password = "12345678";
    public static Connection conn;

    static {
        try {
            conn = getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connect() {
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
