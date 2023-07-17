package jm.task.core.jdbc.util;

//import jm.task.core.jdbc.model.User;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class Util {


    private static final String URL = "jdbc:mysql://localhost:3306/kata_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

//    private static SessionFactory sessionFactory;


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




//    public static SessionFactory getSessionFactory () {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, URL);
//                settings.put(Environment.USER, USER);
//                settings.put(Environment.PASS, PASSWORD);
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//                configuration.setProperties(settings);
//                configuration.addAnnotatedClass(User.class);
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            } catch (Exception e) {
//                System.out.println("Hibernate is not working");
//            }
//        } return sessionFactory;
//    }

}
