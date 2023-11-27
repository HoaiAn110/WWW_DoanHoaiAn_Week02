
<%@ page import="java.util.Optional" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.ProductService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 29/09/2023
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product Page</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Edit Product</p>
                    <%
                        ProductService productService = new ProductService();
                        long id = Long.parseLong(request.getParameter("id"));
                        System.out.println(id);
                        Optional<Product> optional = productService.getProductById(id);
                        Product product = optional.orElseThrow(IllegalAccessError::new);
                    %>
                    <form action="controls?action=updateProduct" method="post">
                        <div class="mb-3">
                            <label class="form-label">Description</label>
                            <input name="dec"
                                   type="text" class="form-control"
                                   value="<%= product.getDescription() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Manufacturer Name</label>
                            <input type="text" name="manu"
                                   class="form-control"
                                   value="<%= product.getManufacturer() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input name="name"
                                   type="text" class="form-control"
                                   value="<%= product.getName() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Unit</label>
                            <input name="unit"
                                   type="text" class="form-control"
                                   value="<%= product.getUnit() %>">
                        </div>
                        <input type="hidden" name="id" value="<%= product.getId()%>">
                        <button type="submit" class="btn btn-primary col-md-12">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
