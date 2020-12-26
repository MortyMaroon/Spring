package com.mortymaroon.contexthibernate.utils;

import com.mortymaroon.contexthibernate.models.Customer;
import com.mortymaroon.contexthibernate.models.Product;
import com.mortymaroon.contexthibernate.models.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionCreator {
    private SessionFactory sessionFactory;

    @PostConstruct
    private void createSessionFactory() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Purchase.class)
                .buildSessionFactory();
    }

    public Session beginTransaction() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

    public void finishTransaction(Session session){
        session.getTransaction().commit();
    }

    public void shutDownFactory() {
        sessionFactory.close();
    }
}
