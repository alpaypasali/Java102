package Week5.Icerık6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    public static void main(String[] args) {
        Connection connect = null;
        String url="jdbc:postgresql://localhost:5432/Shoe?user=postgres&password=postgres";
        try {
            connect= DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
