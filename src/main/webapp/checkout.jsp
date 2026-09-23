<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chique.model.CartItem" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

Boolean adminLoggedIn =
(Boolean) session.getAttribute(
        "admin");

Object loggedInUser =
session.getAttribute(
        "loggedInUser");

ArrayList<CartItem> cart =
(ArrayList<CartItem>)
session.getAttribute("cart");

double subtotal = 0;

if(cart != null){

    for(CartItem item : cart){

        subtotal += item.getPrice()
                * item.getQuantity();
    }
}

double tax = subtotal * 0.05;

double total = subtotal + tax;

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Checkout - Chique</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link rel="preconnect"
href="https://fonts.gstatic.com"
crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500;600;700&display=swap"
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

/* NAVBAR */

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

/* CHECKOUT */

.checkout-section{
    width:90%;
    margin:80px auto;
}

.checkout-title{
    font-size:58px;
    font-family:'Playfair Display', serif;
    color:#b14d73;
    margin-bottom:50px;
}

.checkout-container{
    display:flex;
    gap:40px;
    align-items:flex-start;
}

/* LEFT */

.checkout-form{
    width:65%;
    background:white;
    padding:40px;
    border-radius:28px;
    box-shadow:0 6px 18px rgba(0,0,0,0.05);
}

.checkout-form h2{
    font-size:36px;
    font-family:'Playfair Display', serif;
    margin-bottom:30px;
    color:#2f2f2f;
}

.input-group{
    margin-bottom:22px;
}

.input-group input{
    width:100%;
    padding:18px;
    border:none;
    background:#f7f2f4;
    border-radius:14px;
    outline:none;
    font-size:16px;
}

.row{
    display:flex;
    gap:20px;
}

/* RIGHT */

.order-summary{
    width:35%;
    background:white;
    padding:35px;
    border-radius:28px;
    box-shadow:0 6px 18px rgba(0,0,0,0.05);
}

.order-summary h2{
    font-size:34px;
    font-family:'Playfair Display', serif;
    margin-bottom:30px;
}

.summary-row{
    display:flex;
    justify-content:space-between;
    margin-bottom:20px;
    color:#666;
    font-size:18px;
}

.total{
    font-size:30px;
    color:#b14d73;
    font-weight:bold;
    margin:30px 0;
}

.place-order{
    width:100%;
    padding:18px;
    border:none;
    background:#b14d73;
    color:white;
    border-radius:14px;
    font-size:20px;
    font-family:'Playfair Display', serif;
    cursor:pointer;
    transition:0.3s;
}

.place-order:hover{
    background:#94405f;
}

/* FOOTER */

.footer{
    background:white;
    margin-top:100px;
    padding:60px 20px;
    text-align:center;
    box-shadow:0 -2px 10px rgba(0,0,0,0.04);
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
    font-size:17px;
}

.footer-links{
    margin-bottom:30px;
}

.footer-links a{
    text-decoration:none;
    margin:0 18px;
    color:#444;
    font-family:'Playfair Display', serif;
    font-size:18px;
    transition:0.3s;
}

.footer-links a:hover{
    color:#b14d73;
}

.copyright{
    color:#999;
    font-size:15px;
}

</style>

</head>

<body>

<!-- NAVBAR -->

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

        <a href="admin-dashboard.jsp">

            Admin Panel

        </a>

        <a href="logout">

            Logout

        </a>

        <%

        }

        else if(loggedInUser != null){

        %>

        <a href="orders.jsp">

            My Orders

        </a>

        <a href="logout">

            Logout

        </a>

        <%

        }

        else{

        %>

        <a href="login.jsp">

            Login

        </a>

        <%

        }

        %>

    </div>

</div>
<!-- CHECKOUT -->

<div class="checkout-section">

    <div class="checkout-title">

        Checkout

    </div>

    <div class="checkout-container">

        <!-- LEFT -->

			<form action="place-order" method="post" class="checkout-form">

				<h2>Shipping Details</h2>

				<div class="input-group">

					<input type="text" name="fullName" placeholder="Full Name" required>

				</div>

				<div class="input-group">

					<input type="email" name="email" placeholder="Email Address"
						required>

				</div>

				<div class="input-group">

					<input type="text" name="address" placeholder="Address" required>

				</div>

				<div class="row">

					<div class="input-group">

						<input type="text" name="city" placeholder="City" required>

					</div>

					<div class="input-group">

						<input type="text" name="pincode" placeholder="Pincode" required>

					</div>

				</div>

				<div class="input-group">

					<input type="text" name="cardNumber" placeholder="Card Number"
						required>

				</div>

				<div class="row">

					<div class="input-group">

						<input type="text" name="expiry" placeholder="Expiry" required>

					</div>

					<div class="input-group">

						<input type="text" name="cvv" placeholder="CVV" required>

					</div>

				</div>

				<button type="submit" class="place-order">Place Order</button>

			</form>

			<!-- RIGHT -->

        <div class="order-summary">

            <h2>

                Order Summary

            </h2>

            <div class="summary-row">

                <span>Subtotal</span>

                <span>₹<%=String.format("%.2f", subtotal)%></span>

            </div>

            <div class="summary-row">

                <span>Shipping</span>

                <span>Free</span>

            </div>

            <div class="summary-row">

                <span>Tax (5%)</span>

                <span>₹<%= String.format("%.2f", tax) %></span>

            </div>

            <div class="total">

                Total: ₹<%= String.format("%.2f", total) %>

            </div>

        </div>

    </div>

</div>

<!-- FOOTER -->

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

        <a href="cart.jsp">Cart</a>

        <a href="login.jsp">Login</a>

    </div>

    <div class="copyright">

        © 2026 Chique. All Rights Reserved.

    </div>

</footer>

</body>

</html>