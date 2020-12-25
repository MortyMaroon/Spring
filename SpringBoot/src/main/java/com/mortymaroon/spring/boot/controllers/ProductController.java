package com.mortymaroon.spring.boot.controllers;

import com.mortymaroon.spring.boot.models.Product;
import com.mortymaroon.spring.boot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String showAllProducts(Model model,
                                  @RequestParam(required = false, name = "minPrice") Integer minPrice,
                                  @RequestParam(required = false, name = "maxPrice") Integer maxPrice) {
        model.addAttribute("allProducts", productService.getAllProducts(minPrice, maxPrice));
        return "products";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id) {
        productService.removeById(id);
        return "redirect:/products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addOrUpdateProduct(product);
        return "redirect:/products";
    }
}
