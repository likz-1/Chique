<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.chique.model.Product" %>
<%@ page import="com.chique.dao.ProductDAO" %>
<%@ page import="com.chique.daoimpl.ProductDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chique.model.ProductVariant" %>
<%@ page import="com.chique.dao.ProductVariantDAO" %>
<%@ page import="com.chique.daoimpl.ProductVariantDAOImpl" %>

<%

Boolean admin =
        (Boolean) session.getAttribute(
                "admin");

if(admin == null || !admin){

    response.sendRedirect(
            "login.jsp");

    return;
}

%>

<%

int productId =
        Integer.parseInt(
                request.getParameter("id"));

ProductDAO productDAO =
        new ProductDAOImpl();

Product product =
        productDAO.getProductById(
                productId);

ProductVariantDAO variantDAO =
new ProductVariantDAOImpl();

List<ProductVariant> variants =
variantDAO.getVariantsByProductId(
        productId);

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Product</title>

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
textarea{
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

Edit Product

</h1>

<form action="update-product"
method="post">

<input type="hidden"
name="productId"
value="<%= product.getProductId() %>">

<div class="input-group">

<input type="text"
name="productName"
value="<%= product.getProductName() %>"
required>

</div>

<div class="input-group">

<input type="text"
name="brand"
value="<%= product.getBrand() %>"
required>

</div>

<div class="input-group">

<textarea
name="description"
required><%= product.getDescription() %></textarea>

</div>

<div class="input-group">

<input type="number"
name="price"
value="<%= product.getPrice() %>"
required>

</div>

<div class="input-group">

<input type="text"
name="imageUrl"
value="<%= product.getImageUrl() %>"
required>

</div>

<%

for(ProductVariant variant : variants){

%>

<div class="input-group">

<input type="hidden"
name="variantId"
value="<%= variant.getVariantId() %>">

<input type="text"
value="Size: <%= variant.getSize() %>"
readonly>

</div>

<div class="input-group">

<input type="number"
name="stockQuantity"
value="<%= variant.getStockQuantity() %>"
required>

</div>

<%

}

%>

<button type="submit">

Update Product

</button>

</form>

</div>

</body>

</html>