package com.example.www_doanhoaian_week02_restapi.controllers;


import com.example.www_doanhoaian_week02_restapi.models.CustomerModel;
import com.example.www_doanhoaian_week02_restapi.models.EmployeeModel;
import com.example.www_doanhoaian_week02_restapi.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/controls")
public class ServletController extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EmployeeModel employeeModel = new EmployeeModel();
            CustomerModel customerModel = new CustomerModel();
            ProductModel productModel = new ProductModel();
            Object active = req.getParameter("action");
            if (active.equals("insertEmployee")) {
                employeeModel.insertEmp(req, resp);
            } else if (active.equals("insertCustomer")) {
                customerModel.insertCustomer(req, resp);
            } else if (active.equals("insertProduct")) {
                productModel.insertProduct(req, resp);
            } else if (active.equals("updateEmployee")) {
                employeeModel.updateEmployee(req, resp);
            } else if (active.equals("updateCustomer")) {
                customerModel.updateCustomer(req, resp);
            } else if (active.equals("updateProduct")) {
                productModel.updateProduct(req, resp);
            } else {
                resp.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object object = req.getParameter("action");
            if (object != null) {
                String action = object.toString();
                switch (action) {
                    case "delete_employee":
                        EmployeeModel employeeModel = new EmployeeModel();
                        employeeModel.deleteEmp(req, resp);
                        break;
                    case "delete_cust":
                        CustomerModel customerModel = new CustomerModel();
                        customerModel.deleteCustomer(req, resp);
                        break;
                    case "delete_product":
                        ProductModel productModel = new ProductModel();
                        productModel.deleteProduct(req,resp);
                        break;
                    default:
                        resp.sendRedirect("index.jsp");
                        break;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
