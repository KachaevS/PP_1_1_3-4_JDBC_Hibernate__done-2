package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Connection connection;

    public UserDaoJDBCImpl() {
        connection = Util.getConnection();

    }

    public void createUsersTable() {
        try {
            Statement statement = connection.createStatement();


            String SQL = "CREATE TABLE IF NOT EXISTS users (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);\n";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `kata_db`.`users`;");
            preparedStatement.executeUpdate();
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users (name, lastName, age) VALUES (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();

            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении пользователя");
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Пользователь с id " + id + " удалён.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users;";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `kata_db`.`users`");
            preparedStatement.executeUpdate();
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
