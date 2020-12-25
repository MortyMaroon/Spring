package com.mortymaroon.contexthibernate.repository;

import com.mortymaroon.contexthibernate.utils.SessionCreator;
import com.mortymaroon.contexthibernate.models.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class ProductDAO {
    @Autowired
    private SessionCreator sessionCreator;

    public Product findProductById(Long id) {
        Session session = sessionCreator.beginTransaction();
        Product product = session.get(Product.class, id);
        sessionCreator.finishTransaction(session);
        return  product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionCreator.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
        sessionCreator.finishTransaction(session);
        return  products;
    }

    public Product getProductWithCustomerById(Long id) {
        Session session = sessionCreator.beginTransaction();
        Product product = session
                .createNamedQuery("Product.withCustomer", Product.class)
                .setParameter("id",id)
                .getSingleResult();
        sessionCreator.finishTransaction(session);
        return product;
    }

    public void deleteProductById(Long id) {
        Session session = sessionCreator.beginTransaction();
        session.createNamedQuery("Product.deleteById").setParameter("id",id).executeUpdate();
        sessionCreator.finishTransaction(session);
    }

    public Product createOrUpdateProduct(Product product) {
        Session session = sessionCreator.beginTransaction();
        session.saveOrUpdate(product);
        sessionCreator.finishTransaction(session);
        return  product;
    }
}