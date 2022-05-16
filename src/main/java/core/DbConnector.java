package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class DbConnector {

    private Session session;
    private Properties properties = new Properties();

    public DbConnector() {
        properties.setProperty("hibernate.connection.url",Utils.getProperty("url"));
        properties.setProperty("hibernate.connection.user", Utils.getProperty("username"));
        properties.setProperty("hibernate.connection.password", Utils.getProperty("password"));
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("show_sql", "true");
    }

    public void setSession(Class dto) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(dto)
                .addProperties(properties)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public Object getItem(Class dto, Integer id){
        return session.get(dto, id);
    }

    public void addItem(Object dto){
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
    }

    public void deleteItem(Object dto){
        Transaction transaction = session.beginTransaction();
        session.delete(dto);
        transaction.commit();
    }

    public Object getListItems(String table, Class dto){
        return session.createQuery(String.format("Select items From %s items", table), dto).getResultList();
    }


}
