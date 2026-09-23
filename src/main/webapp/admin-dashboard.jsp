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

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Admin Dashboard - Chique</title>

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

.dashboard{
    width:90%;
    margin:70px auto;
}

.title{
    font-size:54px;
    color:#b14d73;
    margin-bottom:50px;
    font-family:'Playfair Display', serif;
}

.card-container{
    display:grid;
    grid-template-columns:repeat(auto-fit, minmax(280px,1fr));
    gap:30px;
}

.dashboard-card{
    background:white;
    border-radius:24px;
    padding:45px 35px;
    box-shadow:0 6px 20px rgba(0,0,0,0.06);
    text-align:center;
}

.dashboard-card h2{
    font-size:30px;
    margin-bottom:20px;
    color:#2f2f2f;
}

.dashboard-card p{
    color:#666;
    margin-bottom:30px;
    line-height:1.7;
}

.dashboard-btn{
    display:inline-block;
    padding:14px 30px;
    background:#b14d73;
    color:white;
    text-decoration:none;
    border-radius:12px;
    font-size:17px;
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

        <a href="manage-products.jsp">

            Manage Products

        </a>

        <a href="add-product.jsp">

            Add Product

        </a>

        <a href="orders.jsp">

            Orders

        </a>

        <a href="logout">

            Logout

        </a>

    </div>

</div>

<div class="dashboard">

    <div class="title">

        Admin Dashboard

    </div>

    <div class="card-container">

        <div class="dashboard-card">

            <h2>

                Manage Products

            </h2>

            <p>

                View and manage all products available in the store.

            </p>

            <a href="manage-products.jsp"
            class="dashboard-btn">

                Open

            </a>

        </div>

        <div class="dashboard-card">

            <h2>

                Add Products

            </h2>

            <p>

                Add new fashion products and stock variants.

            </p>

            <a href="add-product.jsp"
            class="dashboard-btn">

                Add Product

            </a>

        </div>

        <div class="dashboard-card">

            <h2>

                Customer Orders

            </h2>

            <p>

                View orders placed by customers.

            </p>

            <a href="admin-orders.jsp"
            class="dashboard-btn">

                View Orders

            </a>

        </div>

    </div>

</div>

</body>

</html>