package com.example.www_doanhoaian_week02_restapi.models;


import com.example.www_doanhoaian_week02_restapi.enums.ProductStatus;
import com.example.www_doanhoaian_week02_restapi.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProductModel {
    private final ProductService productService = new ProductService();

    public void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dec = request.getParameter("dec");
        String manufacturer = request.getParameter("manu");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        Product product = new Product(unit, ProductStatus.ACTIVE,manufacturer,name,dec);
        productService.insertProduct(product);
        response.sendRedirect("product-page.jsp");
    }

    public void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("product-page.jsp");
    }

    public void updateProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String dec = request.getParameter("dec");
        String manufacturer = request.getParameter("manu");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        long id = Long.parseLong(request.getParameter("id"));
        Product product = new Product(unit, ProductStatus.ACTIVE,manufacturer,name,dec,id);
        productService.updateProduct(product);
        response.sendRedirect("product-page.jsp");
    }
}
