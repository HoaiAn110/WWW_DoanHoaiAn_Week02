<%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 28/09/2023
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee Page</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Add Employee</p>
                    <form action="controls?action=insertEmployee" method="post">
                        <div class="mb-3">
                            <label class="form-label">Date of birth: </label>
                            <input type="date" class="form-control" name="dob">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email: </label>
                            <input type="email" class="form-control" name="email">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Full Name: </label> <input
                                type="text" class="form-control" name="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Phone: </label> <input
                                type="text" class="form-control" name="phone">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <textarea name="address" class="form-control"></textarea>
                        </div>
                        <div class="d-flex justify-content-between mt-2">
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-secondary">Clear</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
