<%@ page import="java.util.List" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.ProductService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Product" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.ProductImageService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.ProductPriceService" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <%@include file="cdn.jsp" %>
    <style>
        img {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<h1 class="text-center">List products</h1>
<div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">
        <%
            ProductService productService = new ProductService();
            List<Product> products = productService.getProducts();
            ProductImageService productImageService = new ProductImageService();
            ProductPriceService productPriceService = new ProductPriceService();
            for (Product p : products) {
        %>
        <div class="col-md-4 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="image/<%= productImageService.getPatImage(p.getId()).getPath()%>"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=p.getName() %></h5>
                    <h6 class="price">Price: $<%= productPriceService.getPriceOfProduct(p.getId())%></h6>
                    <h6 class="category">Manufacturer name: <%=p.getManufacturer() %></h6>
                    <h6 class="unit">Unit: <%=p.getUnit() %></h6>
                    <h6 class=""><%=p.getDescription()%></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a>
                        <a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>

    </div>
</div>
</body>
</html>
