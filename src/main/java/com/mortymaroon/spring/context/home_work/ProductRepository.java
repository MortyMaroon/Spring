package com.mortymaroon.spring.context.home_work;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProductInRepository(Product product);
    void deleteProduct(Product product);
}
