<%-- 
    Document   : login
    Created on : May 27, 2024, 9:10:17 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="Css/styleLogin.css">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Document Title, Description, and Author -->
        <title>LOGIN FPTEA COFFEE</title>
        <meta name="description" content="FPTEA SHOP COFFEE">
        <link rel="icon" type="image/png" sizes="512x512" href="img/FPT.svg.png">
    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-up">
                <form action="MainController" method="POST">
                    <h1>Create Account</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>or enter your information for create</span>
                    <input type="text" name="userID" required="" placeholder="User ID [4-10]"/> 
                    <input type="text" name="fullName" required="" placeholder="Full Name [5-10]"/> 
                    <input type="hidden" name="roleID" value="US"/> 
                    <input type="password" name="password" required="" placeholder="Password"/> 
                    <input type="password" name="confirm" required="" placeholder="Confirm Password"/> 
                    <button name="action" value="Create">Create</button>
                </form>
            </div>
            <div class="form-container sign-in">
                <form action="MainController" method="POST">
                    <h1>LOGIN</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>or use your userID and password</span>
                    <input type="text" placeholder="User ID" name="userID" required="">
                    <input type="password" placeholder="Password" name="password" required="">              
                    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
                    <div class="g-recaptcha" data-sitekey="6LcjFAUqAAAAAFmn05MmTQkFSNI1-QaN0Q17qKiW"></div><br/>    
                    <button name="action" value="Login">LOGIN</button>
                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>FP-TEA COFFEE</h1>
                        <p>Enter your personal details to drink tea in FP-TEA!</p>
                        <button class="hidden" id="login">Login</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>OOPS..! </h1>
                        <p> ${requestScope.ERROR}</p>                        
                        <button class="hidden" id="register">Create an user now?</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="Javascript/login.js"></script>
    </body>

</html>