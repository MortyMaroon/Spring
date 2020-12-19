package com.mortymaroon.hibernate.crud.product;

import com.mortymaroon.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/crud/product/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown() {
        factory.close();
    }

    public static Product findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public static List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public static void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public static void main(String[] args) {
        try {
            init();
            Product product;
            List<Product> products;
            product = findById(1L);
            System.out.println(product);
            products = findAll();
            System.out.println(products);
            deleteById(1L);
            products = findAll();
            System.out.println(products);
            product = new Product("conditioner", 680);
            saveOrUpdate(product);
            product = findById(4L);
            product.setPrice(5000);
            saveOrUpdate(product);
            products = findAll();
            System.out.println(products);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
