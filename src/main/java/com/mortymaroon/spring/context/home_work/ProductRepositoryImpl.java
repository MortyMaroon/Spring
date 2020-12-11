package com.mortymaroon.spring.context.home_work;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public void addProductInRepository(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product);
    }

    @PostConstruct
    public void initializeRepository() {
        for (int i = 1; i <= 5; i++) {
            products.add(new SimpleProduct(i,String.format("IPhone %d", i + 4),(i + 4) *100));
        }
    }
}
