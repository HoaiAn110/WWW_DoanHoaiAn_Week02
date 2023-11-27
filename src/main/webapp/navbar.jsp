<nav class="navbar bg-body-tertiary justify-content-center">
    <ul class="nav nav-underline">
        <li class="nav-item">
            <a class="nav-link " aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " aria-current="page" href="dashboard.jsp">Dashboard</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Insert</a>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="insert-customer.jsp">Insert Customer</a></li>
                <li><a class="dropdown-item" href="insert-product.jsp">Insert Product</a></li>
                <li><a class="dropdown-item" href="insert-employee.jsp">Insert Employee</a></li>
            </ul>
        </li>
        <li>
            <a class="nav-link" href="product-page.jsp">Product</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="customer-page.jsp">Customer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="employee-page.jsp">Employee</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="cart.jsp">
                Cart <span class="badge badge-danger">${cart_list.size()}</span>
            </a>
        </li>
        <li>
            <a class="nav-link" href="orders.jsp">Order</a>
        </li>

    </ul>
</nav>