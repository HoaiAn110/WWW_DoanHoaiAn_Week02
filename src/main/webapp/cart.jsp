<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Product" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.dto.Cart" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.repositories.ProductRepository" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container my-3">
    <%
        DecimalFormat dcf = new DecimalFormat("#.##");
        request.setAttribute("dcf", dcf);
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        List<Cart> cartProduct = null;
        if (cart_list != null) {
            ProductRepository productRepository = new ProductRepository();
            cartProduct = productRepository.getCartProducts(cart_list);
            double total = productRepository.getTotalCartPrice(cart_list);
            request.setAttribute("total", total);
            request.setAttribute("cart_list", cart_list);
        }
    %>
    <div class="d-flex py-3">
        <div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a
                class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
    </div>

    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cart_list != null) {
                for (Cart c : cartProduct) {
        %>
        <tr>
            <td><%= c.getName() %></td>
            <td><%= dcf.format(c.getPrice()) %></td>
            <td>
                <form class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a class="btn btn-sm btn-success" href="quantity-inc-dec?action=inc&id=<%= c.getId() %>">
                            <i class="fas fa-plus"></i>
                        </a>
                        <input type="text" name="quantity" class="form-control" value="<%= c.getQuantity() %>" readonly>
                        <a class="btn btn-sm btn-warning" href="quantity-inc-dec?action=dec&id=<%= c.getId() %>">
                            <i class="fas fa-minus"></i>
                        </a>
                    </div>
                </form>
            </td>
            <td>
                <a href="remove-from-cart?id=<%= c.getId() %>" class="btn btn-sm btn-danger">Remove</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
