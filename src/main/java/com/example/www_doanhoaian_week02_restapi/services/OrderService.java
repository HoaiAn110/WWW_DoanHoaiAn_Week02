package com.example.www_doanhoaian_week02_restapi.services;



import com.example.www_doanhoaian_week02_restapi.models.Order;
import com.example.www_doanhoaian_week02_restapi.repositories.OrderRepository;

import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService() {
        orderRepository = new OrderRepository();
    }
    public Optional<Order> getOrderLatest(){
        return orderRepository.getOrderLatest();
    }
    public void insertOrder(Order order){
        orderRepository.insertOrder(order);
    }
}
