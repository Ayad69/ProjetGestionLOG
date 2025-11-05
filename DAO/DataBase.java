package src.DAO;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static String url = "jdbc:mysql://localhost:3306/log";
    private static String user = "root";
    private static String pass = "";
    private static Connection connect;

    public static Connection getInstance() {
        if (connect ==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection(url,user,pass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } return connect;
    }
}
