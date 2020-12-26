package com.mortymaroon.contexthibernate.repository;

import com.mortymaroon.contexthibernate.utils.SessionCreator;
import com.mortymaroon.contexthibernate.models.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class CustomerDAO {
    @Autowired
    private SessionCreator sessionCreator;

    public Customer findCustomerById(Long id) {
        Session session = sessionCreator.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        sessionCreator.finishTransaction(session);
        return  customer;
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionCreator.beginTransaction();
        List<Customer> customers = session.createQuery("SELECT c FROM Customer c").getResultList();
        sessionCreator.finishTransaction(session);
        return  customers;
    }

    public Customer getCustomerWithProductsById(Long id) {
        Session session = sessionCreator.beginTransaction();
        Customer customer = session
                .createNamedQuery("Customer.withProducts", Customer.class)
                .setParameter("id",id)
                .getSingleResult();
        sessionCreator.finishTransaction(session);
        return customer;
    }

    public void deleteCustomerById(Long id) {
        Session session = sessionCreator.beginTransaction();
        session.createNamedQuery("Customer.deleteById").setParameter("id",id).executeUpdate();
        sessionCreator.finishTransaction(session);
    }

    public Customer createOrUpdateCustomer(Customer customer) {
        Session session = sessionCreator.beginTransaction();
        session.saveOrUpdate(customer);
        sessionCreator.finishTransaction(session);
        return  customer;
    }

    public Customer getCustomerWithPurchaseById(Long id) {
        Session session = sessionCreator.beginTransaction();
        Customer customer = session
                .createNamedQuery("Customer.withPurchase", Customer.class)
                .setParameter("id",id)
                .getSingleResult();
        sessionCreator.finishTransaction(session);
        return customer;
    }
}