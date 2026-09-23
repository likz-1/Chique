<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Register - Chique</title>

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
href="assets/css/register.css">

<link rel="icon"
href="assets/images/logo.png">

</head>

<body>

<div class="register-container">

    <!-- LEFT -->

    <div class="register-left">

        <img src="assets/images/login.jpg.png">

    </div>

    <!-- RIGHT -->

    <div class="register-right">

    <a href="index.jsp"
    class="logo">

        Chique

    </a>

    <a href="index.jsp"
    class="back-home">

        ← Back to Home

    </a>

    <h2>

        Create Account

    </h2>

    <p>

        Join Chique and explore timeless luxury fashion.

    </p>

    <form action="register"
    method="post">

        <div class="input-box">

            <input type="text"
            name="fullName"
            placeholder="Full Name"
            required>

        </div>

        <div class="input-box">

            <input type="email"
            name="email"
            placeholder="Email Address"
            required>

        </div>

        <div class="input-box">

            <input type="text"
            name="phone"
            placeholder="Phone Number"
            required>

        </div>

        <div class="input-box">

            <input type="password"
            name="password"
            placeholder="Password"
            required>

        </div>

        <div class="input-box">

            <input type="text"
            name="address1"
            placeholder="Address Line 1"
            required>

        </div>

        <div class="input-box">

            <input type="text"
            name="address2"
            placeholder="Address Line 2">

        </div>

        <div class="input-box">

            <input type="text"
            name="city"
            placeholder="City"
            required>

        </div>

        <div class="input-box">

            <input type="text"
            name="state"
            placeholder="State"
            required>

        </div>

        <div class="input-box">

            <input type="text"
            name="pincode"
            placeholder="Pincode"
            required>

        </div>

        <div class="input-box">

            <input type="text"
            name="country"
            placeholder="Country"
            value="India"
            required>

        </div>

        <button type="submit"
        class="register-btn">

            Create Account

        </button>

    </form>

    <div class="bottom-text">

        Already have an account?

        <a href="login.jsp">

            Login

        </a>

    </div>

	</div>
	
</div>

</body>

</html>