package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactoryHere;


    public UserDaoHibernateImpl() {
        sessionFactoryHere = getSessionFactory();
    }


    @Override
    public void createUsersTable() {
        Session session = sessionFactoryHere.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS user (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);\n";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }


    @Override
    public void dropUsersTable() {
        Session session = sessionFactoryHere.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS user;";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactoryHere.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User(name, lastName, age);

        session.persist(user);
        transaction.commit();
        session.close();
        System.out.println("Пользователь " + name + " добавлен в таблицу");


    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactoryHere.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "delete User where id = " + id;
        Query query = session.createQuery(hql);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactoryHere.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);
        List<User> users = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        System.out.println("HIBERNATE: List of users");
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactoryHere.openSession();
        Transaction transaction = session.beginTransaction();
        String SQL = "DELETE FROM user";
        Query query = session.createSQLQuery(SQL).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
        System.out.println("HIBERNATE: Таблица очищена");

    }
}
