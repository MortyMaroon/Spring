package com.mortymaroon.spring.mvc.controller;

import com.mortymaroon.spring.mvc.model.Product;
import com.mortymaroon.spring.mvc.model.SimpleProduct;
import com.mortymaroon.spring.mvc.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("products")
public class ProductController {
    private Service productService;

    @Autowired
    public void setProductService(Service service) {
        this.productService = service;
    }

    @GetMapping("/all")
    public String gelAllProducts(Model model) {
        model.addAttribute("allProducts", productService.getAll());
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute SimpleProduct product) {
        productService.add(product);
        return "redirect:/products/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteBoxById(@PathVariable Long id) {
        productService.delete(productService.getById(id));
        return "redirect:/products/all";
    }
}
