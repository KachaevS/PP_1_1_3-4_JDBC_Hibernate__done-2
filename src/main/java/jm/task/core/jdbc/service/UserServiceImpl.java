package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl dao2 = new UserDaoJDBCImpl();

    public void createUsersTable() {
        dao2.createUsersTable();

    }

    public void dropUsersTable() {
        dao2.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        dao2.saveUser(name, lastName, age);


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
