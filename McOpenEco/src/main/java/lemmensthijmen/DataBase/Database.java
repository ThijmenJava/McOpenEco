package lemmensthijmen.DataBase;

import java.sql.*;

public final class Database {

    private static Connection con;

    public static void connectDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/McOpenEco", "root", "");
            System.out.println("test");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}
