
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.ProductService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 29/09/2023
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Page</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h1 class="text-center">List products</h1>
<div class="container">
    <table class="table container table-bordered table-responsive">
        <thead class="table-dark text-center">
        <tr>
            <th>Product name</th>
            <th>Manufacturer Name</th>
            <th>Unit</th>
            <th>Description</th>
            <td>Delete</td>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <%
            ProductService productService = new ProductService();
            List<Product> products = productService.getProducts();
            for (Product product : products) {
                String delete = "controls?action=delete_product&id=" + product.getId();
        %>
        <tr>
            <td><%= product.getName() %>
            </td>
            <td><%= product.getManufacturer() %>
            </td>
            <td><%= product.getUnit() %>
            </td>
            <td><%= product.getDescription() %>
            </td>
            <td>
                <a class="btn btn-sm btn-danger" href=<%=delete%>>
                    <i class="fa-solid fa-trash"></i>
                </a>
            </td>
            <td>
                <a class="btn btn-sm btn-warning" href="update-product.jsp?id=<%=product.getId()%>">
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
