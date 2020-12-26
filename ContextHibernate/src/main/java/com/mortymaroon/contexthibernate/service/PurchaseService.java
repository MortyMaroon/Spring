package com.mortymaroon.contexthibernate.service;

import com.mortymaroon.contexthibernate.config.ContextConfig;
import com.mortymaroon.contexthibernate.models.Purchase;
import com.mortymaroon.contexthibernate.repository.PurchasesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseService {
    @Autowired
    private PurchasesDAO purchasesDAO;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    public Purchase findPurchaseById(Long id) {
        return purchasesDAO.findPurchaseById(id);
    }

    public List<Purchase> getAllPurchase() {
        return purchasesDAO.getAllPurchase();
    }

    public void deletePurchaseById(Long id) {
        purchasesDAO.deletePurchaseById(id);
    }

    public Purchase createPurchase(Long customerId, Long productId) {
        Purchase purchase = new Purchase();
        purchase.setCustomer(customerService.findCustomerById(customerId));
        purchase.setProduct(productService.findProductById(productId));
        purchase.setPrice(purchase.getProduct().getPrice());
        return purchasesDAO.createOrUpdatePurchases(purchase);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        PurchaseService service = context.getBean(PurchaseService.class);
        service.createPurchase(1L,5L);
    }
}
