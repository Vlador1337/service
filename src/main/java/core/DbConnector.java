package core;

import dto.UserDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import utils.Utils;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Properties;

/**
 * @author Vlador1337
 * Class designed for connection to database
 */
public class DbConnector {

    private Session session;
    private final Properties properties = new Properties();

    /**
     * Creating a constructor for database connection
     * includes connection settings
     */
    public DbConnector() {
        properties.setProperty("hibernate.connection.url", Utils.getProperty("url"));
        properties.setProperty("hibernate.connection.user", Utils.getProperty("username"));
        properties.setProperty("hibernate.connection.password", Utils.getProperty("password"));
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("show_sql", "true");
    }

    /**
     * method to create a session
     *
     * @param dto user data from the database
     * @param <T> parameter T parameterized types
     * @return a database connection
     */
    public <T> DbConnector setSession(Class<T> dto) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(dto)
                .addProperties(properties)
                .buildSessionFactory();
        session = sessionFactory.openSession();
        return this;
    }

    /**
     * getting user from database
     *
     * @param dto user data from the database
     * @param id  user id
     * @param <T> parameter T parameterized types
     * @return session with user
     */
    public <T> T getItem(Class<T> dto, Integer id) {
        return session.get(dto, id);
    }

    /**
     * addition user in Database
     *
     * @param dto user data from the database
     */
    public void addItem(Object dto) {
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
    }

    /**
     * deleting a user from the database
     *
     * @param dto user data from the database
     */
    public void deleteItem(Object dto) {
        Transaction transaction = session.beginTransaction();
        session.delete(dto);
        transaction.commit();
    }

    /**
     * @param table table from database
     * @param dto   getting user from database
     * @param <T>   parameter T parameterized types
     * @return users from database
     */
    public <T> List<T> getListItems(String table, Class<T> dto) {
        return session.createQuery(String.format("Select items From %s items", table), dto).getResultList();
    }

    /**
     * @param email user email
     * @param pas   user password
     * @return user from database
     */
    public UserDto findUser(String email, String pas) {
        try {
            Query query = session.createQuery("from users where userEmail = :mailParam and userPas = :pasParam");
            query.setParameter("mailParam", email);
            query.setParameter("pasParam", pas);
            return (UserDto) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("User not found");
        }
        return null;
    }


}
