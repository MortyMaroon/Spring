package com.mortymaroon.spring.context.home_work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartImpl implements Cart {
    @Autowired
    private ProductRepository productRepository;
    private List<Product> productsInCart;

    public CartImpl(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public CartImpl() {
        this.productsInCart = new ArrayList<>();
    }

    @Override
    public void addProductById(int id) {
        productsInCart.add(productRepository.getProductById(id));
    }

    @Override
    public void deleteProductById(int id) {
        productsInCart.remove(productRepository.getProductById(id));
    }

    @Override
    public void showProducts() {
        System.out.println(productsInCart.toString());
    }
}
