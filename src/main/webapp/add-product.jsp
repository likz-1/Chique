<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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

<title>Add Product - Chique Admin</title>

<style>

body{
    background:#fdf7f9;
    font-family:Arial;
}

.container{
    width:50%;
    margin:50px auto;
    background:white;
    padding:40px;
    border-radius:25px;
}

h1{
    text-align:center;
    color:#b14d73;
    margin-bottom:35px;
}

.input-group{
    margin-bottom:20px;
}

input,
textarea,
select{
    width:100%;
    padding:15px;
    border:none;
    border-radius:10px;
    background:#f5f0f2;
}

button{
    width:100%;
    padding:18px;
    border:none;
    border-radius:12px;
    background:#b14d73;
    color:white;
    font-size:18px;
    cursor:pointer;
}

</style>

</head>

<body>

<div class="container">

<h1>

Add Product

</h1>

<form action="add-product"
method="post">

<div class="input-group">

<input type="text"
name="productName"
placeholder="Product Name"
required>

</div>

<div class="input-group">

<input type="text"
name="brand"
placeholder="Brand"
required>

</div>

<div class="input-group">

<textarea
name="description"
placeholder="Description"
required></textarea>

</div>

<div class="input-group">

<input type="number"
name="price"
placeholder="Price"
required>

</div>

<div class="input-group">

<input type="text"
name="imageUrl"
placeholder="Image URL"
required>

</div>

<div class="input-group">

<select name="categoryId">

<option value="1">

Women

</option>

<option value="2">

Men

</option>

<option value="3">

Footwear

</option>

<option value="4">

Accessories

</option>

</select>

</div>

<div class="input-group">

<input type="text"
name="size"
placeholder="Size (S/M/L/XL)"
required>

</div>

<div class="input-group">

<input type="number"
name="stockQuantity"
placeholder="Stock Quantity"
required>

</div>

<button type="submit">

Add Product

</button>

</form>

</div>

</body>

</html>