package com.example.www_doanhoaian_week02_restapi.models;


import com.example.www_doanhoaian_week02_restapi.services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomerModel {
    private final CustomerService customerService = new CustomerService();

    public void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email =  request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Customer customer = new Customer(address,name,email,phone);
        customerService.insertCustomer(customer);
        response.sendRedirect("customer-page.jsp");
    }
    public void deleteCustomer(HttpServletRequest request,HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        customerService.deleteCustomer(id);
        response.sendRedirect("customer-page.jsp");
    }
    public void updateCustomer(HttpServletRequest request,HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email =  request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Customer customer = new Customer(address,id,name,email,phone);
        customerService.updateCustomer(customer);
        response.sendRedirect("customer-page.jsp");
    }
}
