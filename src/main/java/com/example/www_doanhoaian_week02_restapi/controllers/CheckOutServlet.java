package com.example.www_doanhoaian_week02_restapi.controllers;

import com.example.www_doanhoaian_week02_restapi.dto.Cart;
import com.example.www_doanhoaian_week02_restapi.models.Customer;
import com.example.www_doanhoaian_week02_restapi.models.Employee;
import com.example.www_doanhoaian_week02_restapi.models.Order;
import com.example.www_doanhoaian_week02_restapi.models.OrderDetail;
import com.example.www_doanhoaian_week02_restapi.repositories.OrderDetailRepository;
import com.example.www_doanhoaian_week02_restapi.services.OrderService;
import com.example.www_doanhoaian_week02_restapi.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
    private final ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            OrderService orderService = new OrderService();

            Random random = new Random();
            long empId = (long) random.nextInt(10) + 1;
            long customerId = (long) random.nextInt(10) + 1;
            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            List<Cart> carts = productService.getProductByCart(cart_list);
            if (carts != null) {
                Order order = new Order();
                order.setOrderDate(LocalDateTime.now());
                order.setCustomer(new Customer(customerId));
                order.setEmployee(new Employee(empId));
                orderService.insertOrder(order);
                for (Cart c : carts) {
                    System.out.println(c.getId());
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setQuantity(c.getQuantity());
                    orderDetail.setPrice(c.getPrice());
                    orderDetail.setOrder(order);
                    orderDetail.setNote("Order Complete");
                    orderDetail.setProduct(productService.getProductById(c.getId()).orElseThrow(IOException::new));
                    System.out.println(orderDetail);
                    orderDetailRepository.insertOrderDetail(orderDetail);
                }
                cart_list.clear();
                response.sendRedirect("orders.jsp");
            } else {
                response.sendRedirect("cart.jsp");
            }
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}