package com.mortymaroon.hibernate.crud.simple_item;

import com.mortymaroon.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

    public static void showManyItems() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<SimpleItem> items = session.createQuery("from SimpleItem").getResultList();
            System.out.println(items + "\n");

            SimpleItem si1 = session.createQuery("select s from SimpleItem s where s.id = 3", SimpleItem.class).getSingleResult();
            System.out.println(si1 + "\n");

            List<SimpleItem> cheapItems = session.createQuery("select s from SimpleItem s where s.price < 80").getResultList();
            System.out.println(cheapItems + "\n");

            session.getTransaction().commit();
        }
    }

    public static void createExample() {
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem dragonStatue = new SimpleItem("Dragon Statue",100);
            session.saveOrUpdate(dragonStatue);
            session.getTransaction().commit();
        }
    }

    public static void readAndPrintExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
            System.out.println(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void updateExample() {
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
            session.delete(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void deleteExample() {
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
            simpleItem.setPrice(10000);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
            createExample();
            readAndPrintExample();
            updateExample();
            deleteExample();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

}