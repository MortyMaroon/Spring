package com.mortymaroon.spring.boot.repositorys;

import com.mortymaroon.spring.boot.models.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    ProductRepository() {
        this.products = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        products.add(new Product(1L,"IPhone5",500));
        products.add(new Product(2L,"IPhone6",540));
        products.add(new Product(3L,"IPhone7",600));
        products.add(new Product(4L,"IPhone8",650));
    }

    public List<Product> getAllProducts() {
        return products;
//        return Collections.unmodifiableList(products);
    }

    public Product addOrUpdateProduct(Product product) {
        if (product.getId() != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i,product);
                    return product;
                }
            }
        }
        Long newProductId = products.stream().mapToLong(Product::getId).max().orElseGet(() ->0L) + 1L;
        product.setId(newProductId);
        products.add(product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return products.stream().
                filter(product -> product.getId().equals(id)).
                findFirst();
    }

    public void removeById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
