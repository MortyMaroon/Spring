package com.mortymaroon.springdata.controllers;

import com.mortymaroon.springdata.models.Product;
import com.mortymaroon.springdata.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(name = "min_price", required = false, defaultValue = "0") Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice) {
        return productRepository.findAllByPriceBetween(minPrice,maxPrice != null ? maxPrice : Integer.MAX_VALUE);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
