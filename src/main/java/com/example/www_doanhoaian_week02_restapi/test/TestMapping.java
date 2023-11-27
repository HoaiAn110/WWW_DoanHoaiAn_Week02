package com.example.www_doanhoaian_week02_restapi.test;


import com.example.www_doanhoaian_week02_restapi.models.Order;
import com.example.www_doanhoaian_week02_restapi.models.OrderDetail;
import com.example.www_doanhoaian_week02_restapi.models.Product;
import com.example.www_doanhoaian_week02_restapi.services.OrderDetailService;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.Random;

public class TestMapping {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 200; i++) {
            // Ensure unique order IDs
            long orderId = (long) Math.floor(Math.random() * (123 - 74 + 1) + 74);

            long productId = (long) random.nextInt(10) + 1;
            double quantity = Math.floor(Math.random() * (20 - 5 + 1) + 5);

            // Use BigDecimal for precision in prices
            BigDecimal price = BigDecimal.valueOf(Math.floor(Math.random() * (500000 - 10000 + 1) + 10000));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(new Product(productId));
            orderDetail.setQuantity(quantity);
            orderDetail.setNote("Order Complete");
            orderDetail.setOrder(new Order(orderId));
            orderDetail.setPrice(20000);
            orderDetailService.insertOrderDetail(orderDetail);
        }
    }
}
