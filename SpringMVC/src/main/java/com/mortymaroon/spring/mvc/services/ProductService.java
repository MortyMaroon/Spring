package com.mortymaroon.spring.mvc.services;

import com.mortymaroon.spring.mvc.model.Product;
import com.mortymaroon.spring.mvc.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService implements Service{
    private Repository productRepository;

    @Autowired
    public void setProductRepository(Repository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }
}
