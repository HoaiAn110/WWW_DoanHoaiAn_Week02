package com.example.www_doanhoaian_week02_restapi.models;



import com.example.www_doanhoaian_week02_restapi.enums.EmployeeStatus;
import com.example.www_doanhoaian_week02_restapi.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeModel {
    private final EmployeeService employeeService = new EmployeeService();

    public void insertEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDob = LocalDate.parse(dob, formatter);
        Employee employee = new Employee(formatDob.atStartOfDay(), email, address, EmployeeStatus.ACTIVE, phone, name);
        employeeService.insertEmp(employee);
        response.sendRedirect("employee-page.jsp");
    }

    public void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        employeeService.deleteEmp(id);
        response.sendRedirect("employee-page.jsp");
    }

    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        long id = Long.parseLong(request.getParameter("id"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDob = LocalDate.parse(dob, formatter);
        Employee employeeUpdate = new Employee(formatDob.atStartOfDay(),id,email,address,EmployeeStatus.ACTIVE,phone,name);
        employeeService.updateEmp(employeeUpdate);
        response.sendRedirect("employee-page.jsp");
    }
}
