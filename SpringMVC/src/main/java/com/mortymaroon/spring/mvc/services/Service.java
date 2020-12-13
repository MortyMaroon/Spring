package com.mortymaroon.spring.mvc.services;

import com.mortymaroon.spring.mvc.model.Product;

import java.util.List;

public interface Service {
    List<Product> getAll();
    void add(Product product);
    void delete(Product product);
    Product getById(Long id);
}
