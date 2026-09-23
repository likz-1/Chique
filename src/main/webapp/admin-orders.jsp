<%@ page import="java.util.List" %>

<%@ page import="com.chique.model.Order" %>
<%@ page import="com.chique.dao.OrderDAO" %>

<%@ page import="com.chique.daoimpl.OrderDAOImpl" %>

<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<%

Boolean adminLoggedIn =
(Boolean) session.getAttribute(
        "admin");

if(adminLoggedIn == null
        || !adminLoggedIn){

    response.sendRedirect(
            "login.jsp");

    return;
}

OrderDAO orderDAO =
        new OrderDAOImpl();

List<Order> orders =
        orderDAO.getAllOrders();

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Admin Orders - Chique</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link rel="preconnect"
href="https://fonts.gstatic.com"
crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500;700&display=swap"
rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    background:#fdf7f9;
    font-family:Arial;
}

.navbar{
    width:100%;
    height:82px;
    background:white;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:0 80px;
    box-shadow:0 2px 10px rgba(0,0,0,0.05);
}

.logo{
    font-family:'Great Vibes', cursive;
    font-size:68px;
    color:#b14d73;
}

.nav-links a{
    text-decoration:none;
    margin-left:35px;
    color:#333;
    font-size:18px;
    font-family:'Playfair Display', serif;
}

.container{
    width:90%;
    margin:60px auto;
}

.title{
    font-size:52px;
    color:#b14d73;
    margin-bottom:40px;
    font-family:'Playfair Display', serif;
}

.order-card{
    background:white;
    border-radius:24px;
    padding:35px;
    margin-bottom:30px;
    box-shadow:0 6px 18px rgba(0,0,0,0.05);
}

.order-row{
    display:flex;
    justify-content:space-between;
    margin-bottom:18px;
    color:#444;
    font-size:18px;
}

.status{
    color:#b14d73;
    font-weight:bold;
}

</style>

</head>

<body>

<div class="navbar">

    <div class="logo">

        Chique

    </div>

    <div class="nav-links">

        <a href="admin-dashboard.jsp">

            Dashboard

        </a>

        <a href="manage-products.jsp">

            Products

        </a>

        <a href="logout">

            Logout

        </a>

    </div>

</div>

<div class="container">

    <div class="title">

        Customer Orders

    </div>

    <%

    for(Order order : orders){

    %>

    <div class="order-card">

        <div class="order-row">

            <span>Order ID</span>

            <span>#<%= order.getOrderId() %></span>

        </div>

        <div class="order-row">

            <span>User ID</span>

            <span><%= order.getUserId() %></span>

        </div>

        <div class="order-row">

            <span>Total Amount</span>

            <span>₹<%= order.getTotalAmount() %></span>

        </div>

        <div class="order-row">

            <span>Payment Method</span>

            <span><%= order.getPaymentMethod() %></span>

        </div>

			<div class="order-row">

				<span>Status</span> <span class="status"> <%=order.getOrderStatus()%>

				</span>

			</div>

			<form action="update-order-status" method="post"
				style="margin-top: 20px;">

				<input type="hidden" name="orderId"
					value="<%=order.getOrderId()%>"> <select
					name="orderStatus"
					style="padding: 10px; border: none; border-radius: 10px; background: #f5f0f2; width: 220px; font-size: 16px;">

					<option value="Placed">Placed</option>

					<option value="Processing">Processing</option>

					<option value="Shipped">Shipped</option>

					<option value="Delivered">Delivered</option>

					<option value="Cancelled">Cancelled</option>

				</select>

				<button type="submit"
					style="padding: 10px 18px; border: none; border-radius: 10px; background: #b14d73; color: white; margin-left: 10px; cursor: pointer;">

					Update Status</button>

			</form>
			
			<div class="order-row">

            <span>Shipping Address</span>

            <span><%=order.getShippingAddress()%></span>

        </div>

        <div class="order-row">

            <span>Order Date</span>

            <span><%= order.getOrderDate() %></span>

        </div>

    </div>

    <%

    }

    %>

</div>

</body>

</html>