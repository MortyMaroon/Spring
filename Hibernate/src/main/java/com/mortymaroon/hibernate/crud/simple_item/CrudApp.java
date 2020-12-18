package com.mortymaroon.hibernate.crud.simple_item;

import com.mortymaroon.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/crud/simple_item/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown() {
        factory.close();
    }

    public static void createExample() {
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem dragonStatue = new SimpleItem("Dragon Statue",100);
            System.out.println(dragonStatue);
            session.saveOrUpdate(dragonStatue);
            System.out.println(dragonStatue);
            session.getTransaction().commit();
            System.out.println(dragonStatue);
        }
    }

    public static void main(String[] args) {
        try {
            init();
            createExample();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

}