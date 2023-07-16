package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private static final String URL = "jdbc:mysql://localhost:3306/kata_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public static Connection getConnection() {


        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            return DriverManager.getConnection(URL, USER, PASSWORD);


        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение.");
        }
        return null;
    }

}
