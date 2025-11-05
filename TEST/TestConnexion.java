package src.TEST;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import src.DAO.DataBase;

public class TestConnexion {
    public void testCon() {
        try{
            Connection connect = DataBase.getInstance();
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("show databases;");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e); }
    }
}
