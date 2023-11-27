
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.CustomerService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Customer" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 29/09/2023
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h2 class="text-center m-5">List Customers</h2>
<div class="d-flex justify-content-center mb-3">
    <div class="col-6">
        <a type="button" class="btn btn-secondary" href="insert-customer.jsp">Insert</a>
    </div>
    <div class="col-5">
        <div class="input-group">
            <input type="text" placeholder="Search" class="form-control">
            <button class="btn btn-primary" type="button">Search</button>
        </div>
    </div>
</div>

<div class="container">
    <table class="table table-bordered table-responsive">
        <thead class="table-dark">
        <tr>
            <th>Address</th>
            <th>Email</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <%
            CustomerService customerService = new CustomerService();
            List<Customer> customers = customerService.getCustomers();
            for (Customer customer : customers) {
                String delete = "controls?action=delete_cust&id=" + customer.getId();

        %>
        <tr>
            <td><%= customer.getAddress() %>
            </td>
            <td><%= customer.getEmail() %>
            </td>
            <td><%= customer.getName() %>
            </td>
            <td><%= customer.getPhone()%>
            </td>
            <td>
                <a class="btn btn-sm btn-danger" href=<%=delete%>><i class="fa-solid fa-trash"></i></a>
            </td>
            <td>
                <a class="btn btn-sm btn-warning" href="update-customer.jsp?id=<%=customer.getId()%>">
                    <i class="fa-regular fa-pen-to-square"></i>
                </a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
