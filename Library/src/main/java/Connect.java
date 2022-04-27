import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/图书管理系统";
        String user = "root";
        String password = "12345678";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not connected");
        }
    }
}
