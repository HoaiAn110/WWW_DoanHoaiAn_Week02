
<%@ page import="java.util.Optional" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.EmployeeService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 29/09/2023
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Edit Employee</p>

                    <%

                        EmployeeService employeeService = new EmployeeService();
                        long id = Long.parseLong(request.getParameter("id"));
                        Optional<Employee> optionalEmployee = employeeService.getEmployeeById(id);
                        Employee employee = optionalEmployee.orElseThrow(IllegalAccessError::new);
                    %>

                    <form action="controls?action=updateEmployee" method="post">
                        <div class="mb-3">
                            <label class="form-label">Date of birth: </label>
                            <input

                                    type="date" class="form-control"
                                    value="<%= employee.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %>"
                                    name="dob">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email: </label>
                            <input name="email"
                                   type="text" class="form-control"
                                   value="<%= employee.getEmail() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Full Name: </label>
                            <input type="text" name="name"
                                   class="form-control"
                                   value="<%= employee.getFullName() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Phone: </label>
                            <input name="phone"
                                   type="text" class="form-control"
                                   value="<%= employee.getPhone() %>">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address: </label>
                            <input class="form-control" name="address" value=" <%= employee.getAddress() %>">


                        </div>
                        <input type="hidden" name="id" value="<%= employee.getId()%>">
                        <button type="submit" class="btn btn-primary col-md-12">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
