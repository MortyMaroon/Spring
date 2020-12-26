package com.mortymaroon.contexthibernate.repository;

import com.mortymaroon.contexthibernate.models.Purchase;
import com.mortymaroon.contexthibernate.utils.SessionCreator;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchasesDAO {
    @Autowired
    private SessionCreator sessionCreator;

    public Purchase findPurchaseById(Long id) {
        Session session = sessionCreator.beginTransaction();
        Purchase purchase = session.get(Purchase.class, id);
        sessionCreator.finishTransaction(session);
        return  purchase;
    }

    public List<Purchase> getAllPurchase() {
        Session session = sessionCreator.beginTransaction();
        List<Purchase> purchases = session.createQuery("SELECT p FROM Purchase p").getResultList();
        sessionCreator.finishTransaction(session);
        return  purchases;
    }

    public void deletePurchaseById(Long id) {
        Session session = sessionCreator.beginTransaction();
        session.createNamedQuery("Purchases.deleteById").setParameter("id",id).executeUpdate();
        sessionCreator.finishTransaction(session);
    }

    public Purchase createOrUpdatePurchases(Purchase purchases) {
        Session session = sessionCreator.beginTransaction();
        session.saveOrUpdate(purchases);
        sessionCreator.finishTransaction(session);
        return  purchases;
    }
}
