<%-- 
    Document   : viewProfile
    Created on : Jun 22, 2024, 10:14:51 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Document Title, Description, and Author -->
        <title>Profile</title>
        <meta name="description" content="FPTEA SHOP COFFEE">
         <link rel="icon" type="image/png" sizes="512x512" href="img/FPT.svg.png">
        <link rel="stylesheet" href="Css/styleProfile.css"/>
        <link rel="icon" type="image/x-icon" href="https://th.bing.com/th/id/R.e15d750fe41eb99350f0c56e6b66b653?rik=QJI66s2o67Q7jw&pid=ImgRaw&r=0">

    </head>
    <body>
    <body>
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID != 'US'}">
        <c:redirect url="login.html"></c:redirect>
    </c:if>   
    <h2 class="title">Personal Information</h2>
    <div class="p-infor">         
        <form action="MainController" method="post">
            <div class="grid-container">
                <div class="grid-part">
                    <div class="tag">User ID</div>
                    <input class="input" type="text" value="${sessionScope.LOGIN_USER.userID}" name="userID" readonly="">
                </div>
                <div class="grid-part">
                    <div class="tag">Full Name</div>
                    <input class="input" type="text" value="${sessionScope.LOGIN_USER.fullName}" readonly="">
                </div>
                <div class="grid-part">
                    <div class="tag">Role ID</div>
                    <input class="input" type="text" value="US" readonly="">
                </div>
                <div class="grid-part">
                    <div class="tag">Status</div>
                    <input class="input" type="text" value="Active" readonly="">
                </div>
                <div class="grid-part">
                    <div class="tag">Password</div>
                    <input class="input" id="password" type="password" value="*******" readonly=""y>
                </div>
            </div>
            <div class="submit-part">
                <button class="submit" type="submit"  name="action" value="Back_Home" >Home</button>                
            </div>
        </form>

    </div>
</body>
</html>
