<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>

<%@ page import="com.chique.model.Product" %>
<%@ page import="com.chique.model.ProductVariant" %>

<%@ page import="com.chique.dao.ProductDAO" %>
<%@ page import="com.chique.dao.ProductVariantDAO" %>

<%@ page import="com.chique.daoimpl.ProductDAOImpl" %>
<%@ page import="com.chique.daoimpl.ProductVariantDAOImpl" %>

<%

Boolean adminLoggedIn =
(Boolean) session.getAttribute(
        "admin");

Object loggedInUser =
session.getAttribute(
        "loggedInUser");

String productName =
        request.getParameter("name");

if(productName == null){

    response.sendRedirect(
            "index.jsp");

    return;
}

ProductDAO productDAO =
        new ProductDAOImpl();

Product product = null;

for(Product p : productDAO.getAllProducts()){

    if(p.getProductName().equals(productName)){

        product = p;
        break;
    }
}

if(product == null){

    response.sendRedirect(
            "index.jsp");

    return;
}

String image =
        product.getImageUrl();

String description =
        product.getDescription();

String price =
        product.getPrice().toString();

ProductVariantDAO variantDAO =
        new ProductVariantDAOImpl();

List<ProductVariant> variants =
        variantDAO.getVariantsByProductId(
                product.getProductId());

boolean hasVariants =
        variants != null
        && !variants.isEmpty();

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title><%= productName %> - Chique</title>

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

.product-section{
    width:90%;
    margin:80px auto;
    display:flex;
    gap:60px;
    align-items:center;
}

.product-image{
    width:50%;
}

.product-image img{
    width:100%;
    border-radius:28px;
    box-shadow:0 8px 25px rgba(0,0,0,0.08);
}

.product-details{
    width:50%;
}

.product-details h1{
    font-size:58px;
    font-family:'Playfair Display', serif;
    color:#2f2f2f;
    margin-bottom:20px;
}

.product-details p{
    font-size:18px;
    color:#666;
    line-height:1.8;
    margin-bottom:25px;
}

.price{
    font-size:36px;
    color:#b14d73;
    font-weight:bold;
    margin-bottom:30px;
}

.size-title{
    font-size:20px;
    margin-bottom:15px;
    color:#333;
}

.sizes{
    display:flex;
    gap:15px;
    margin-bottom:35px;
    flex-wrap:wrap;
}

.sizes button{
    min-width:70px;
    height:55px;
    padding:0 12px;
    border:none;
    border-radius:12px;
    background:#f5e9ee;
    cursor:pointer;
    font-size:15px;
    transition:0.3s;
    color:#333;
}

.sizes button:hover{
    background:#b14d73;
    color:white;
}

.sizes button:disabled{
    background:#ddd;
    color:#888;
    cursor:not-allowed;
}

.active-size{
    background:#b14d73 !important;
    color:white;
}

.cart-btn{
    width:260px;
    padding:16px;
    border:none;
    background:#b14d73;
    color:white;
    border-radius:12px;
    font-size:18px;
    cursor:pointer;
    font-family:'Playfair Display', serif;
    transition:0.3s;
}

.cart-btn:hover{
    background:#94405f;
    transform:translateY(-2px);
}

.cart-btn:disabled{
    background:#999;
    cursor:not-allowed;
}

.extra-info{
    margin-top:40px;
    color:#666;
    line-height:2;
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

.stock-info{
    margin-top:-18px;
    margin-bottom:28px;
    color:#777;
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

<div class="product-section">

    <div class="product-image">

        <img src="<%= image %>"
        alt="<%= productName %>">

    </div>

    <div class="product-details">

        <h1>

            <%= productName %>

        </h1>

        <p>

            <%= description %>

        </p>

        <div class="price">

            ₹<%= price %>

        </div>

        <div class="size-title">

            Select Size

        </div>

        <%

        if(hasVariants){

        %>

        <div class="sizes">

            <%

            boolean first = true;

            for(ProductVariant variant : variants){

            %>

            <button type="button"

            <%= variant.getStockQuantity() <= 0
            ? "disabled"
            : "" %>

            onclick="selectSize('<%= variant.getSize() %>', this)"

            class="size-btn
            <%= first ? "active-size" : "" %>">

                <%= variant.getSize() %>

                <br>

                (<%= variant.getStockQuantity() %>)

            </button>

            <%

            first = false;

            }

            %>

        </div>

        <div class="stock-info">

            Available stock shown beside each size.

        </div>

        <%

        }

        else{

        %>

        <div style="color:red;
        font-size:18px;
        margin-bottom:30px;">

            No sizes available for this product.

        </div>

        <%

        }

        %>

        <form action="add-to-cart"
        method="post">

            <input type="hidden"
            name="productName"
            value="<%= productName %>">

            <input type="hidden"
            name="price"
            value="<%= price %>">

            <input type="hidden"
            name="image"
            value="<%= image %>">

            <input type="hidden"
            id="selectedSize"
            name="size"
            value="<%= hasVariants
            ? variants.get(0).getSize()
            : "" %>">

            <button type="submit"
            class="cart-btn"

            <%= !hasVariants
            ? "disabled"
            : "" %>>

                <%= hasVariants
                ? "Add to Cart"
                : "Out Of Stock" %>

            </button>

        </form>

        <div class="extra-info">

            ✔ Premium Fabric <br>

            ✔ Free Shipping <br>

            ✔ 7 Days Easy Return <br>

            ✔ Luxury Packaging

        </div>

    </div>

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

<script>

function selectSize(size, button) {

    document.getElementById(
        "selectedSize").value = size;

    let buttons =
        document.querySelectorAll(".size-btn");

    buttons.forEach(btn => {

        btn.classList.remove(
            "active-size");
    });

    button.classList.add(
        "active-size");
}

</script>

</body>

</html>