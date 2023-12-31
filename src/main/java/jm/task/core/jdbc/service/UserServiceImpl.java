package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao dao2 = new UserDaoHibernateImpl();

    public void createUsersTable() {
        dao2.createUsersTable();

    }

    public void dropUsersTable() {
        dao2.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            dao2.saveUser(name, lastName, age);
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении пользователя");
        }

    }

    public void removeUserById(long id) {
        dao2.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return dao2.getAllUsers();
    }

    public void cleanUsersTable() {
        dao2.cleanUsersTable();

    }
}
