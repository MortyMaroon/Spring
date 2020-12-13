package com.mortymaroon.spring.mvc.repository;

import com.mortymaroon.spring.mvc.model.Product;
import com.mortymaroon.spring.mvc.model.SimpleProduct;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository implements Repository{
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        products.add(new SimpleProduct(1L,"IPhone5", 500));
        products.add(new SimpleProduct(2L,"IPhone6", 600));
        products.add(new SimpleProduct(3L,"IPhone7", 700));
        products.add(new SimpleProduct(4L,"IPhone8", 800));
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public Product getById(Long id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().get();
    }
}
