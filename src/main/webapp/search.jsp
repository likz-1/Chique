<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>

<%@ page import="com.chique.model.Product" %>

<%@ page import="com.chique.dao.ProductDAO" %>

<%@ page import="com.chique.daoimpl.ProductDAOImpl" %>

<%

String keyword =
request.getParameter("keyword");

if(keyword == null){

    keyword = "";
}

ProductDAO productDAO =
        new ProductDAOImpl();

List<Product> productList =
        productDAO.searchProducts(
                keyword);

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>

Search Products - Chique

</title>

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

.search-box{
    width:90%;
    margin:40px auto;
    display:flex;
    gap:20px;
}

.search-box input{
    flex:1;
    padding:16px;
    border:none;
    border-radius:12px;
    font-size:16px;
}

.search-box button{
    padding:16px 30px;
    border:none;
    background:#b14d73;
    color:white;
    border-radius:12px;
    cursor:pointer;
}

.products{
    width:90%;
    margin:40px auto;
    display:grid;
    grid-template-columns:
    repeat(auto-fit,minmax(260px,1fr));
    gap:35px;
}

.card{
    background:white;
    border-radius:24px;
    overflow:hidden;
    box-shadow:0 6px 18px rgba(0,0,0,0.06);
    transition:0.3s;
}

.card:hover{
    transform:translateY(-6px);
}

.card img{
    width:100%;
    height:320px;
    object-fit:cover;
}

.card-content{
    padding:20px;
}

.card-content h2{
    font-size:28px;
    margin-bottom:12px;
    font-family:'Playfair Display', serif;
}

.price{
    color:#b14d73;
    font-size:24px;
    font-weight:bold;
    margin-top:15px;
}

.view-btn{
    display:inline-block;
    margin-top:18px;
    padding:12px 22px;
    background:#b14d73;
    color:white;
    text-decoration:none;
    border-radius:10px;
}

.no-products{
    text-align:center;
    font-size:24px;
    color:#777;
    margin-top:80px;
}

</style>

</head>

<body>

<div class="navbar">

    <div class="logo">

        Chique

    </div>

</div>

<form action="search.jsp"
method="get"
class="search-box">

    <input type="text"
    name="keyword"

    placeholder="Search products..."

    value="<%= keyword %>">

    <button type="submit">

        Search

    </button>

</form>

<%

if(productList.isEmpty()){

%>

<div class="no-products">

    No products found.

</div>

<%

}

else{

%>

<div class="products">

<%

for(Product product : productList){

%>

<div class="card">

    <img src="<%= product.getImageUrl() %>">

    <div class="card-content">

        <h2>

            <%= product.getProductName() %>

        </h2>

        <p>

            <%= product.getDescription() %>

        </p>

        <div class="price">

            ₹<%= product.getPrice() %>

        </div>

        <a href="product.jsp?name=<%= product.getProductName() %>"
        class="view-btn">

            View Product

        </a>

    </div>

</div>

<%

}

%>

</div>

<%

}

%>

</body>

</html>