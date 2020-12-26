package com.mortymaroon.contexthibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "purchases")
@NamedQueries({
        @NamedQuery(name = "Purchase.deleteById", query = "DELETE FROM Purchase p WHERE p.id = :id"),
})
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price")
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Purchase() {
    }

    public Purchase(Customer customer, Product product, int price) {
        this.customer = customer;
        this.product = product;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Purchase [id = %d, customer = %s, product = %s, price = %d]", id, customer.getTitle(), product.getTitle(), price);
    }
}
