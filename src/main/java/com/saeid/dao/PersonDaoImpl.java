package com.saeid.dao;

import com.saeid.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDaoImpl implements PersonDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Person p) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();

    }

    public List<Person> list() {
        Session session = sessionFactory.openSession();
        List persons = session.createQuery("from Person").list();
        session.close();
        return persons;
    }
}
