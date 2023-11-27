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
    <title>Insert Product Page</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Add Product</p>
                    <form action="controls?action=insertProduct" method="post">
                        <div class="mb-3">
                            <label class="form-label">Description </label>
                            <input type="text" class="form-control" name="dec">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Manufacturer Name: </label>
                            <input type="text" class="form-control" name="manu">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Product Name: </label> <input
                                type="text" class="form-control" name="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Unit: </label> <input
                                type="text" class="form-control" name="unit">
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
