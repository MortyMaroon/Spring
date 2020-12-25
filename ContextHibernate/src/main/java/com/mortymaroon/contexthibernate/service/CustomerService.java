package com.mortymaroon.contexthibernate.service;

import com.mortymaroon.contexthibernate.models.Customer;
import com.mortymaroon.contexthibernate.models.Product;
import com.mortymaroon.contexthibernate.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public Customer findCustomerById(Long id) {
        return  customerDAO.findCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public List<Product> getProductByCustomerId(Long id) {
        return customerDAO.getCustomerWithProductsById(id).getProducts();
    }

    public void deleteCustomerById(Long id) {
        customerDAO.deleteCustomerById(id);
    }

    public Customer saveOrUpdateCustomer(Customer customer) {
        return customerDAO.createOrUpdateCustomer(customer);
    }
}
