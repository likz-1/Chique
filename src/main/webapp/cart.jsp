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

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Cart - Chique</title>

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
    font-family:Arial;
    background:#fdf7f9;
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

.cart-container{
    width:90%;
    margin:60px auto;
}

h1{
    font-family:'Playfair Display', serif;
    margin-bottom:40px;
    color:#2f2f2f;
    font-size:48px;
}

.cart-card{
    background:white;
    border-radius:20px;
    padding:25px;
    display:flex;
    align-items:center;
    gap:25px;
    margin-bottom:25px;
    box-shadow:0 6px 20px rgba(0,0,0,0.06);
}

.cart-card img{
    width:140px;
    height:160px;
    object-fit:cover;
    border-radius:16px;
}

.cart-details{
    flex:1;
}

.cart-details h2{
    font-size:28px;
    margin-bottom:10px;
    font-family:'Playfair Display', serif;
}

.cart-details p{
    color:#666;
    margin-bottom:8px;
    font-size:17px;
}

.price{
    color:#b14d73;
    font-size:26px;
    font-weight:bold;
    margin-top:10px;
}

.item-total{
    margin-top:10px;
    font-size:18px;
    color:#444;
}

.quantity-box{
    display:flex;
    align-items:center;
    gap:12px;
    margin-top:15px;
}

.quantity-btn{
    width:38px;
    height:38px;
    border:none;
    border-radius:10px;
    background:#b14d73;
    color:white;
    font-size:20px;
    cursor:pointer;
}

.quantity-number{
    font-size:18px;
    min-width:30px;
    text-align:center;
}

.remove-btn{
    margin-top:18px;
    padding:12px 20px;
    border:none;
    border-radius:10px;
    background:#222;
    color:white;
    cursor:pointer;
}

.total-section{
    margin-top:40px;
    background:white;
    padding:30px;
    border-radius:20px;
    box-shadow:0 6px 20px rgba(0,0,0,0.06);
}

.total{
    font-size:34px;
    font-family:'Playfair Display', serif;
    color:#2f2f2f;
    margin-bottom:25px;
}

.checkout-btn{
    display:inline-block;
    padding:18px 40px;
    background:#b14d73;
    color:white;
    text-decoration:none;
    border-radius:14px;
    font-size:18px;
    font-family:'Playfair Display', serif;
    transition:0.3s;
}

.checkout-btn:hover{
    background:#94405f;
}

.empty-cart{
    font-size:24px;
    color:#777;
    margin-top:40px;
    text-align:center;
}

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
}

.copyright{
    color:#999;
    font-size:15px;
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

<div class="cart-container">

<h1>

    Shopping Cart

</h1>

<%

ArrayList<CartItem> cart =
(ArrayList<CartItem>)
session.getAttribute("cart");

double total = 0;

if(cart != null && !cart.isEmpty()) {

    for(int i = 0; i < cart.size(); i++) {

        CartItem item = cart.get(i);

        double itemTotal =
                item.getPrice()
                * item.getQuantity();

        total += itemTotal;

%>

<div class="cart-card">

    <img src="<%= item.getImageUrl() %>"
    alt="Cart Product">

    <div class="cart-details">

        <h2>

            <%= item.getProductName() %>

        </h2>

        <p>

            Size:
            <%= item.getSize() %>

        </p>

        <div class="quantity-box">

            <form action="update-cart"
            method="post">

                <input type="hidden"
                name="index"
                value="<%= i %>">

                <input type="hidden"
                name="action"
                value="decrease">

                <button class="quantity-btn"
                type="submit">

                    -

                </button>

            </form>

            <div class="quantity-number">

                <%= item.getQuantity() %>

            </div>

            <form action="update-cart"
            method="post">

                <input type="hidden"
                name="index"
                value="<%= i %>">

                <input type="hidden"
                name="action"
                value="increase">

                <button class="quantity-btn"
                type="submit">

                    +

                </button>

            </form>

        </div>

        <div class="price">

            ₹<%= item.getPrice() %>

        </div>

        <div class="item-total">

            Item Total:
            ₹<%= String.format("%.2f", itemTotal) %>

        </div>

        <form action="remove-cart-item"
        method="post">

            <input type="hidden"
            name="index"
            value="<%= i %>">

            <button type="submit"
            class="remove-btn">

                Remove Item

            </button>

        </form>

    </div>

</div>

<%

    }

%>

<div class="total-section">

    <div class="total">

        Total:
        ₹<%= String.format("%.2f", total) %>

    </div>

    <a href="checkout.jsp"
    class="checkout-btn">

        Proceed to Checkout

    </a>

</div>

<%

} else {

%>

<div class="empty-cart">

    Your cart is empty.

</div>

<%

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

        <a href="cart.jsp">Cart</a>

    </div>

    <div class="copyright">

        © 2026 Chique. All Rights Reserved.

    </div>

</footer>

</body>

</html>