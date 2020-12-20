package com.mortymaroon.spring.mvc.repository;

import com.mortymaroon.spring.mvc.model.Product;

import java.util.List;

public interface Repository {
    List<Product> getAll();
    Product getById(Long id);
    void add(Product product);
    void delete(Product product);
}
