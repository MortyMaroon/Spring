package com.mortymaroon.spring.boot.services;

import com.mortymaroon.spring.boot.models.Product;
import com.mortymaroon.spring.boot.repositorys.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product addOrUpdateProduct(Product product) {
        return productRepository.addOrUpdateProduct(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void removeById(Long id) {
        productRepository.removeById(id);
    }

    public List<Product> getAllProducts(Integer minPrice, Integer maxPrice) {
        List<Product> filteredProducts = getAllProducts();
        if (minPrice != null) {
            filteredProducts = filteredProducts.stream().
                    filter(product -> product.getPrice() >= minPrice).
                    collect(Collectors.toList());
        }
        if (maxPrice != null) {
            filteredProducts = filteredProducts.stream().
                    filter(product -> product.getPrice() <= maxPrice).
                    collect(Collectors.toList());
        }
        return filteredProducts;
    }
}
