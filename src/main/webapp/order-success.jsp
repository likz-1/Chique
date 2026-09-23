<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

Boolean adminLoggedIn =
(Boolean) session.getAttribute(
        "admin");

Object loggedInUser =
session.getAttribute(
        "loggedInUser");

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Order Success - Chique</title>

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

/* SUCCESS SECTION */

.success-section{
    width:100%;
    min-height:80vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:40px;
}

.success-card{
    width:700px;
    background:white;
    padding:70px 50px;
    border-radius:30px;
    text-align:center;
    box-shadow:0 10px 30px rgba(0,0,0,0.06);
}

.success-icon{
    font-size:90px;
    margin-bottom:25px;
}

.success-card h1{
    font-size:54px;
    color:#b14d73;
    font-family:'Playfair Display', serif;
    margin-bottom:20px;
}

.success-card p{
    font-size:20px;
    color:#666;
    line-height:1.8;
    margin-bottom:40px;
}

.home-btn{
    display:inline-block;
    padding:16px 40px;
    background:#b14d73;
    color:white;
    text-decoration:none;
    border-radius:14px;
    font-size:18px;
    font-family:'Playfair Display', serif;
    transition:0.3s;
}

.home-btn:hover{
    background:#94405f;
}

/* FOOTER */

.footer{
    background:white;
    padding:50px 20px;
    text-align:center;
    box-shadow:0 -2px 10px rgba(0,0,0,0.04);
}

.footer-logo{
    font-family:'Great Vibes', cursive;
    font-size:58px;
    color:#b14d73;
    margin-bottom:18px;
}

.footer p{
    color:#777;
    margin-bottom:20px;
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

<!-- SUCCESS -->

<div class="success-section">

    <div class="success-card">

        <div class="success-icon">

            ✔

        </div>

        <h1>

            Order Placed Successfully

        </h1>

        <p>

            Thank you for shopping with Chique.
            Your luxury order has been placed successfully
            and will be delivered soon.

        </p>

        <a href="index.jsp"
        class="home-btn">

            Continue Shopping

        </a>

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

    <div class="copyright">

        © 2026 Chique. All Rights Reserved.

    </div>

</footer>

</body>

</html>