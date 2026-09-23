<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.chique.model.Product" %>
<%@ page import="com.chique.dao.ProductDAO" %>
<%@ page import="com.chique.daoimpl.ProductDAOImpl" %>

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

<%

ProductDAO productDAO =
        new ProductDAOImpl();

List<Product> products =
        productDAO.getAllProducts();

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Manage Products - Chique</title>

<style>

body{
    font-family:Arial;
    background:#fdf7f9;
    padding:40px;
}

h1{
    text-align:center;
    color:#b14d73;
    margin-bottom:40px;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
}

th, td{
    padding:18px;
    border:1px solid #ddd;
    text-align:center;
}

th{
    background:#b14d73;
    color:white;
}

img{
    width:90px;
    border-radius:10px;
}

button{
    background:red;
    color:white;
    border:none;
    padding:12px 18px;
    border-radius:8px;
    cursor:pointer;
}

button:hover{
    opacity:0.8;
}

</style>

</head>

<body>

<h1>

    Manage Products

</h1>

<table>

<tr>

    <th>ID</th>

    <th>Image</th>

    <th>Name</th>

    <th>Price</th>

    <th>Edit</th>
    
	<th>Delete</th>

</tr>

<%

for(Product product : products){

%>

<tr>

    <td>

        <%= product.getProductId() %>

    </td>

    <td>

        <img src="<%= product.getImageUrl() %>">

    </td>

    <td>

        <%= product.getProductName() %>

    </td>

    <td>

        ₹<%= product.getPrice() %>

    </td>

	<td>

	    <a href="edit-product.jsp?id=<%= product.getProductId() %>">
	
	        <button
	        style="background:#b14d73;">
	
	            Edit
	
	        </button>
	
	    </a>
	
	</td>
	
	<td>
	
	    <form action="delete-product"
	    method="post">
	
	        <input type="hidden"
	        name="productId"
	        value="<%= product.getProductId() %>">
	
	        <button type="submit">
	
	            Delete
	
	        </button>
	
	    </form>
	
	</td>

</tr>

<%

}

%>

</table>

</body>

</html>