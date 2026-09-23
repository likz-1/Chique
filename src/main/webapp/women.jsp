<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.chique.model.Product" %>
<%@ page import="com.chique.dao.ProductDAO" %>
<%@ page import="com.chique.daoimpl.ProductDAOImpl" %>

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

<title>Women Collection - Chique</title>

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link rel="preconnect"
href="https://fonts.gstatic.com"
crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
href="assets/css/style.css">

<link rel="icon"
href="assets/images/logo.png">

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
        
        <a href="search.jsp">Search</a>

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

<!-- HERO -->

<div class="hero">

    <div class="hero-image">

        <img src="assets/images/women.jpg.png"
        alt="Women Collection">

    </div>

    <div class="hero-content">

        <h1>

            Women Collection

        </h1>

        <p>

            Explore elegant silhouettes, luxury fabrics,
            and timeless feminine fashion.

        </p>

    </div>

</div>

<!-- PRODUCTS -->

<div class="products">

    <h2>

        Featured Products

    </h2>

    <div class="product-container">

        <%

        ProductDAO productDAO =
                new ProductDAOImpl();

        List<Product> products =
                productDAO.getProductsByCategory(1);

        for(Product product : products){

        %>

        <div class="product-card">

            <img src="<%= product.getImageUrl() %>"
            alt="<%= product.getProductName() %>">

            <div class="product-info">

                <h3>

                    <%= product.getProductName() %>

                </h3>

                <p>

                    <%= product.getDescription() %>

                </p>

                <div class="price">

                    ₹<%= product.getPrice() %>

                </div>

                <a href="product.jsp?name=<%= product.getProductName() %>">

                    <button>

                        View Product

                    </button>

                </a>

            </div>

        </div>

        <%

        }

        %>

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

    </div>

    <div class="copyright">

        © 2026 Chique. All