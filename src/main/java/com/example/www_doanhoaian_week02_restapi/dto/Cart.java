package com.example.www_doanhoaian_week02_restapi.dto;


import com.example.www_doanhoaian_week02_restapi.enums.ProductStatus;
import com.example.www_doanhoaian_week02_restapi.models.Product;

public class Cart extends Product {
    private double quantity;
    private double price;

    public Cart(String unit, ProductStatus productStatus, String manufacturer, String name, String description, long id, double quantity, double price) {
        super(unit, productStatus, manufacturer, name, description, id);
        this.quantity = quantity;
        this.price = price;
    }

    public Cart() {
    }
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "quantity=" + quantity +
                ", price=" + price +
                "} " + super.toString();
    }
}
