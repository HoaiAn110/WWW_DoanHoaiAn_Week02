package com.example.www_doanhoaian_week02_restapi.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
@NamedQueries({
        @NamedQuery(
                name = "ProductPrice.getPriceByProductId",
                query = "select price.price FROM ProductPrice price " +
                        "where product.id =: id order by price.priceDateTime DESC LIMIT 1"
        ),
        @NamedQuery(name = "ProductPrice.getDateAndPriceByProductId", query = "SELECT p.priceDateTime, p.price from ProductPrice p where product.id = :productId")
})
public class ProductPrice {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;
    private double price;
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product product, LocalDateTime priceDateTime, double price, String note) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPriceDateTime(LocalDateTime now) {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
