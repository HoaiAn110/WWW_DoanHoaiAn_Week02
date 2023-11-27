package com.example.www_doanhoaian_week02_restapi.services;


import com.example.www_doanhoaian_week02_restapi.models.OrderDetail;
import com.example.www_doanhoaian_week02_restapi.repositories.OrderDetailRepository;

public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService() {
         orderDetailRepository = new OrderDetailRepository();
    }
    public void insertOrderDetail(OrderDetail orderDetail){
        orderDetailRepository.insertOrderDetail(orderDetail);
    }
    public void updateOrderDetail(OrderDetail orderDetailNew){
        orderDetailRepository.update(orderDetailNew);
    }
//    public List<OrderDetail> getCartProducts(ArrayList<OrderDetail> orderDetails){
//        List<OrderDetail> rs = new ArrayList<>();
//        if(orderDetails.size()  > 0){
//            for(OrderDetail orderDetail : orderDetails){
//
//            }
//        }
//    }
}
