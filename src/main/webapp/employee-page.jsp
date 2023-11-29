
<%@ page import="java.util.List" %>

<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.services.EmployeeService" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 28/09/2023
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Page</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <h2 class="text-center m-5">List Employee</h2>
    <div class="d-flex justify-content-center mb-3">
        <div class="col-6">
            <button type="button" class="btn btn-secondary">Insert</button>
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
                <th>Full name</th>
                <th>Address</th>
                <th>Date of birth</th>
                <th>Email</th>
                <th>Status</th>

                <th>Phone</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <%
                EmployeeService employeeService = new EmployeeService();
                List<Employee> employees = employeeService.getAll();
                for (Employee employee : employees) {
                    String delete = "controls?action=delete_employee&id=" + employee.getId();
            %>
            <tr>
                <td><%= employee.getFullName() %></td>
                <td><%= employee.getAddress() %></td>
                <td><%= employee.getDob().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %></td>
                <td><%= employee.getEmail() %></td>
                <td><%= employee.getEmployeeStatus()%></td>

                <td><%= employee.getPhone() %></td>
                <td>
                    <a class="btn btn-danger" href=<%=delete%>>
                        <i class="fa-solid fa-trash"></i>
                    </a>
                </td>
                <td>
                    <a class="btn btn-sm btn-warning" href="update-employee.jsp?id=<%=employee.getId()%>">
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
