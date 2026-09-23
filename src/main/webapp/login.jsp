<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Login - Chique</title>

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
href="assets/css/login.css">

<link rel="icon"
href="assets/images/logo.png">

</head>

<body>

<div class="login-container">

    <!-- LEFT -->

    <div class="login-left">

        <img src="assets/images/login.jpg.png"
        alt="Login Image">

    </div>

    <!-- RIGHT -->

    <div class="login-right">

        <!-- LOGO -->

        <a href="index.jsp"
        class="logo">

            Chique

        </a>

        <!-- BACK -->

        <a href="index.jsp"
        class="back-home">

            ← Back to Home

        </a>

        <!-- HEADING -->

        <h2>

            Welcome Back

        </h2>

        <p>

            Login to continue your luxury fashion experience.

        </p>

        <!-- LOGIN FORM -->

        <form action="login"
        method="post">

            <div class="input-box">

                <input type="email"
                name="email"
                placeholder="Email Address"
                required>

            </div>

            <div class="input-box">

                <input type="password"
                name="password"
                placeholder="Password"
                required>

            </div>

            <!-- OPTIONS -->

            <div class="login-options">

                <label>

                    <input type="checkbox">

                    Remember Me

                </label>

                <a href="#">

                    Forgot Password?

                </a>

            </div>

            <!-- ADMIN LOGIN -->

            <div style="margin-bottom:20px;
            display:flex;
            align-items:center;
            gap:10px;
            font-size:15px;
            color:#555;">

                <input type="checkbox"
                name="admin">

                <span>

                    Login as Admin

                </span>

            </div>

            <!-- BUTTON -->

            <button type="submit"
            class="login-btn">

                Login

            </button>

        </form>

        <!-- DIVIDER -->

        <div class="divider">

            OR

        </div>

        <!-- SOCIAL LOGIN -->

        <div class="social-login">

            <button type="button">

                Google

            </button>

            <button type="button">

                Apple

            </button>

        </div>

        <!-- REGISTER -->

        <div class="bottom-text">

            Don’t have an account?

            <a href="register.jsp">

                Register

            </a>

        </div>

    </div>

</div>

</body>

</html>