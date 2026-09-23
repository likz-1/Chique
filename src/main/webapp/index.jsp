<%@ page import="com.chique.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

User loggedInUser =
(User) session.getAttribute(
        "loggedInUser");

Boolean adminLoggedIn =
(Boolean) session.getAttribute(
        "admin");

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Chique</title>

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

<!-- TOP BAR -->

<div class="top-bar">

    FREE SHIPPING ON ALL ORDERS ABOVE ₹2999

</div>

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

    <div class="hero-content">

        <h1>

            Luxury Fashion

        </h1>

        <p>

            Timeless elegance for modern wardrobes.

        </p>

        <a href="#arrivals">

            <button>

                Shop Now

            </button>

        </a>

    </div>

    <div class="hero-image">

        <img src="assets/images/hero.jpg.jpeg"
        alt="Luxury Fashion">

    </div>

</div>

<!-- CATEGORIES -->

<div class="categories">

    <h2>

        Featured Collections

    </h2>

    <div class="category-container">

        <!-- WOMEN -->

        <a href="women.jsp"
        class="category-link">

            <div class="category-card">

                <img src="assets/images/women.jpg.png"
                alt="Women Collection">

                <h3>

                    Women

                </h3>

            </div>

        </a>

        <!-- MEN -->

        <a href="men.jsp"
        class="category-link">

            <div class="category-card">

                <img src="assets/images/men.jpg.jpeg"
                alt="Men Collection">

                <h3>

                    Men

                </h3>

            </div>

        </a>

        <!-- FOOTWEAR -->

        <a href="footwear.jsp"
        class="category-link">

            <div class="category-card">

                <img src="assets/images/footwear.jpg.png"
                alt="Footwear">

                <h3>

                    Footwear

                </h3>

            </div>

        </a>

        <!-- ACCESSORIES -->

        <a href="accessories.jsp"
        class="category-link">

            <div class="category-card">

                <img src="assets/images/accessories.jpg.jpeg"
                alt="Accessories">

                <h3>

                    Accessories

                </h3>

            </div>

        </a>

    </div>

</div>

<!-- NEW ARRIVALS -->

<div class="arrivals"
id="arrivals">

    <h2>

        New Arrivals

    </h2>

    <div class="product-container">

        <!-- PRODUCT 1 -->

        <div class="product-card">

            <img src="assets/images/product1.jpg.jpeg"
            alt="Blush Blazer">

            <div class="product-info">

                <h3>

                    Blush Blazer

                </h3>

                <p>

                    Elegant pastel blazer for a refined luxury look.

                </p>

                <div class="price">

                    ₹4,999

                </div>

                <a href="product.jsp?name=Blush Blazer">

                    <button>

                        View Product

                    </button>

                </a>

            </div>

        </div>

        <!-- PRODUCT 2 -->

        <div class="product-card">

            <img src="assets/images/product2.jpg.png"
            alt="Nude Heels">

            <div class="product-info">

                <h3>

                    Nude Heels

                </h3>

                <p>

                    Minimal luxury footwear with timeless elegance.

                </p>

                <div class="price">

                    ₹3,499

                </div>

                <a href="product.jsp?name=Nude Heels">

                    <button>

                        View Product

                    </button>

                </a>

            </div>

        </div>

        <!-- PRODUCT 3 -->

        <div class="product-card">

            <img src="assets/images/product3.jpg.png"
            alt="Rose Handbag">

            <div class="product-info">

                <h3>

                    Rose Handbag

                </h3>

                <p>

                    Chic designer handbag crafted for modern fashion.

                </p>

                <div class="price">

                    ₹5,999

                </div>

                <a href="product.jsp?name=Rose Handbag">

                    <button>

                        View Product

                    </button>

                </a>

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

    </div>

    <div class="copyright">

        © 2026 Chique. All Rights Reserved.

    </div>

</footer>

</body>

</html>