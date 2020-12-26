package com.mortymaroon.contexthibernate.service;

import com.mortymaroon.contexthibernate.models.Customer;
import com.mortymaroon.contexthibernate.models.Product;
import com.mortymaroon.contexthibernate.models.Purchase;
import com.mortymaroon.contexthibernate.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public Product findProductById(Long id) {
        return  productDAO.findProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public List<Customer> getCustomersByProductId(Long id) {
        return  productDAO.getProductWithCustomerById(id).getCustomers();
    }

    public void deleteProductById(Long id) {
        productDAO.deleteProductById(id);
    }

    public Product saveOrUpdateProduct(Product product) {
        return productDAO.createOrUpdateProduct(product);
    }

    public List<Purchase> getPurchasesByProductId(Long id) {
        return productDAO.getProductWithPurchaseById(id).getPurchases();
    }
}
