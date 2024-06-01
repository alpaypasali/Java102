package Week5.Icerık6;

import java.sql.*;

public class DbConn {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/Patika";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "postgres";
    public static void main(String[] args) throws SQLException {
        Connection connect = null;
        Statement st =null;
        PreparedStatement pt = null;
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connect.setAutoCommit(false);
            st = connect.createStatement();

            String insertSql1 ="INSERT INTO employess (name, position, salary) VALUES ('Alpay Pasali' , 'Developer' , 1000)";
            String insertSql2 ="INSERT INTO employess (name, position, salary) VALUES ('Ahment Uzun' , 'Manager' , 5000)";
            String insertSql3 ="INSERT INTO employess (name, position, salary) VALUES ('Okan  Ja' , 'CEO' , 10000)";
            String insertSql4 ="INSERT INTO employess (name, position, salary) VALUES ('Gamze Bak' , 'HR' , 3000)";
            String insertSql5 ="INSERT INTO employess (name, position, salary) VALUES ('Ayse Gur' , 'Sales' , 4000)";

            st.executeUpdate(insertSql1);
            st.executeUpdate(insertSql2);
            st.executeUpdate(insertSql3);
            st.executeUpdate(insertSql4);
            st.executeUpdate(insertSql5);

            System.out.println("Create Successful");



            PrintSql(connect);
            System.out.println("--------------------------------------------------------------------");
            PreparedStatement pr = connect.prepareStatement("UPDATE employess SET name=?, position=? WHERE id=?");
            pr.setString(1, "deneme");
            pr.setString(2, "deneme2");
            pr.setInt(3, 1);
            pr.executeUpdate();

            PrintSql(connect);

            connect.commit();
            connect.close();







        } catch (SQLException e) {
            if (connect != null) {
                connect.rollback();
            }
            System.out.println(e.getMessage());
        }


    }
    public static void PrintSql(Connection connection) throws SQLException {
        Statement st =connection.createStatement();
        String query = "Select * from employess";
        ResultSet resultSet = st.executeQuery(query);
        while (resultSet.next()) {
            // take data
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String position = resultSet.getString("position");
            double salary = resultSet.getDouble("salary");

            // Wiew the results to the screen
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Position: " + position);
            System.out.println("Salary: " + salary);
            System.out.println("--------------------------");
        }

        resultSet.close();


    }
}
