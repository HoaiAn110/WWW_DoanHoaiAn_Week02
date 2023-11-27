
<%@ page import="java.util.Optional" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.CustomerService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Customer" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 29/09/2023
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Customer</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Edit Customer</p>
                    <%
                        CustomerService customerService = new CustomerService();
                        long id = Long.parseLong(request.getParameter("id"));
                        System.out.println(id);
                        Optional<Customer> optional = customerService.getCustomerById(id);
                        Customer customer = optional.orElseThrow(IllegalAccessError::new);
                    %>
                    <form action="controls?action=updateCustomer" method="post">
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input name="email"
                                   type="text" class="form-control"
                                   value="<%= customer.getEmail() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Customer Name</label>
                            <input type="text" name="name"
                                   class="form-control"
                                   value="<%= customer.getName() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Phone</label>
                            <input name="phone"
                                   type="text" class="form-control"
                                   value="<%= customer.getPhone() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input class="form-control text-center" name="address" value="<%=customer.getAddress()%>">

                        </div>
                        <input type="hidden" name="id" value="<%= customer.getId()%>">
                        <button type="submit" class="btn btn-primary col-md-12">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
