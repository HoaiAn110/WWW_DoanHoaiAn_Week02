<%@ page import="com.example.www_doanhoaian_week02_restapi.repositories.OrderRepository" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.repositories.OrderDetailRepository" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 28/09/2023
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Detail</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="card-header-my-3">All Order</div>
    <table class="table table-hover">
        <thead class="table-header">
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Price</th>
            <th scope="col">Customer</th>
            <th scope="col">Employee</th>
        </tr>
        </thead>
        <tbody>
        <%
            OrderRepository orderRepository = new OrderRepository();
            List<Order> orders = orderRepository.getAll();
            OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
            if (orders != null) {
                for (Order o : orders) {%>
        <tr>
            <td><%=o.getOrderDate() %>
            </td>
            <td><%=orderDetailRepository.getTotalPrice(o.getId()) %>
            </td>
            <td><%=o.getCustomer().getName() %>
            </td>
            <td><%=o.getEmployee().getFullName() %>
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
