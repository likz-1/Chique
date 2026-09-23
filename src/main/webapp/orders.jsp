<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%@ page import="com.chique.model.User" %>
<%@ page import="com.chique.model.Order" %>
<%@ page import="com.chique.model.OrderItem" %>

<%@ page import="com.chique.dao.OrderDAO" %>
<%@ page import="com.chique.dao.OrderItemDAO" %>

<%@ page import="com.chique.daoimpl.OrderDAOImpl" %>
<%@ page import="com.chique.daoimpl.OrderItemDAOImpl" %>

<%
Boolean adminLoggedIn =
(Boolean) session.getAttribute("admin");

User loggedInUser =
(User) session.getAttribute(
        "loggedInUser");

if(loggedInUser == null){

    response.sendRedirect(
            "login.jsp");

    return;
}

OrderDAO orderDAO =
        new OrderDAOImpl();

OrderItemDAO orderItemDAO =
        new OrderItemDAOImpl();

List<Order> orders =
        orderDAO.getOrdersByUserId(
                loggedInUser.getUserId());
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Orders - Chique</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link rel="preconnect"
href="https://fonts.gstatic.com"
crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500;700&display=swap"
rel="stylesheet">

<link rel="icon"
href="assets/images/logo.png">

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
    margin-left:38px;
    color:#333;
    font-size:18px;
    font-family:'Playfair Display', serif;
}

.container{
    width:90%;
    margin:60px auto;
}

.page-title{
    font-size:48px;
    margin-bottom:40px;
    color:#2f2f2f;
    font-family:'Playfair Display', serif;
}

.order-card{
    background:white;
    border-radius:24px;
    padding:35px;
    margin-bottom:35px;
    box-shadow:0 6px 20px rgba(0,0,0,0.06);
}

.order-top{
    display:flex;
    justify-content:space-between;
    margin-bottom:25px;
    flex-wrap:wrap;
    gap:20px;
}

.order-id{
    font-size:28px;
    color:#2f2f2f;
    font-family:'Playfair Display', serif;
}

.order-date{
    color:#777;
    margin-top:8px;
}

.order-status{
    background:#b14d73;
    color:white;
    padding:12px 22px;
    border-radius:12px;
    height:fit-content;
}

.order-total{
    margin-top:18px;
    font-size:22px;
    color:#444;
}

.items-title{
    margin-top:25px;
    margin-bottom:20px;
    font-size:22px;
    color:#2f2f2f;
}

.item-box{
    background:#fdf7f9;
    padding:18px;
    border-radius:14px;
    margin-bottom:15px;
}

.item-box p{
    margin-bottom:8px;
    color:#555;
}

.empty-orders{
    text-align:center;
    color:#777;
    font-size:24px;
    margin-top:60px;
}

.footer{
    background:white;
    margin-top:100px;
    padding:60px 20px;
    text-align:center;
}

.footer-logo{
    font-family:'Great Vibes', cursive;
    font-size:60px;
    color:#b14d73;
    margin-bottom:18px;
}

.footer p{
    color:#777;
    margin-bottom:30px;
}

.footer-links a{
    text-decoration:none;
    margin:0 18px;
    color:#444;
    font-family:'Playfair Display', serif;
}

</style>

</head>

<body>

<div class="navbar">

    <div class="logo">

        Chique

    </div>

    <div class="nav-links">

        <a href="index.jsp">Home</a>

        <a href="women.jsp">Women</a>

        <a href="men.jsp">Men</a>

        <a href="footwear.jsp">Footwear</a>

        <a href="accessories.jsp">Accessories</a>

        <a href="cart.jsp">Cart</a>

        <%

		if(adminLoggedIn != null
		        && adminLoggedIn){
		
		%>
		
		<a href="manage-products.jsp">
		
		    Admin Panel
		
		</a>
		
		<%
		
		}
		
		%>
		
		<a href="orders.jsp">
		
		    My Orders
		
		</a>
		
		<a href="logout">
		
		    Logout
		
		</a>

    </div>

</div>

<div class="container">

<div class="page-title">

    My Orders

</div>

<%

if(orders.isEmpty()){

%>

<div class="empty-orders">

    No orders placed yet.

</div>

<%

}

else{

    for(Order order : orders){

        List<OrderItem> items =
                orderItemDAO
                .getOrderItemsByOrderId(
                        order.getOrderId());

%>

<div class="order-card">

    <div class="order-top">

        <div>

            <div class="order-id">

                Order #<%= order.getOrderId() %>

            </div>

            <div class="order-date">

                <%= order.getOrderDate() %>

            </div>

            <div class="order-total">

                Total:
                ₹<%= order.getTotalAmount() %>

            </div>

        </div>

        <div class="order-status">

            <%= order.getOrderStatus() %>

        </div>

    </div>

    <div class="items-title">

        Ordered Items

    </div>

    <%

    for(OrderItem item : items){

    %>

    <div class="item-box">

        <p>

            Variant ID:
            <%= item.getVariantId() %>

        </p>

        <p>

            Quantity:
            <%= item.getQuantity() %>

        </p>

        <p>

            Price:
            ₹<%= item.getPrice() %>

        </p>

    </div>

    <%

    }

    %>

</div>

<%

    }

}

%>

</div>

<footer class="footer">

    <div class="footer-logo">

        Chique

    </div>

    <p>

        Timeless luxury fashion crafted for modern elegance.

    </p>

    <div class="footer-links">

        <a href="index.jsp">Home</a>

        <a href="women.jsp">Women</a>

        <a href="men.jsp">Men</a>

        <a href="footwear.jsp">Footwear</a>

        <a href="accessories.jsp">Accessories</a>

    </div>

</footer>

</body>

</html>