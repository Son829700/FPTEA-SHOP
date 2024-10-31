<%-- 
    Document   : userShopping
    Created on : Jul 2, 2024, 8:09:04 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required Meta Tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Document Title, Description, and Author -->
        <title>FPTEA COFFEE</title>
        <meta name="description" content="FPTEA SHOP COFFEE">
         <link rel="icon" type="image/png" sizes="512x512" href="img/FPT.svg.png">
        <meta name="author" content="BootstrapBrain">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="Css/styleUserShopping.css">
       
        <!-- Google Fonts Files -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
              integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Load jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- Popper.js -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- CSS Files -->

        <link rel="stylesheet" href="Css/styleUserShopping.css">
        <!-- BSB Head -->

    </head>

    <body class="bsb-tpl-bg-50 py-3 py-md-5 py-xl-6">
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID != 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>   
        <!-- Header -->

        <c:import url="components/header.jsp" />


        <!-- Hero 6 - WELCOME Component -->
        <section class="py-4 py-md-5 py-xl-8">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="container-fluid bsb-hero-6 bsb-overlay border border-dark" style="--bsb-overlay-opacity: 0.5; --bsb-overlay-bg-color: var(--bs-light-rgb); background-image: url('img/coffee-bg.jpg');">
                            <div class="row justify-content-md-center align-items-center">
                                <div class="col-12 col-md-11 col-xl-10">
                                    <h2 class="display-1 text-center text-md-start text-shadow-head fw-bold mb-4">Welcome ${sessionScope.LOGIN_USER.fullName} to FPTEA COFFEE</h2>
                                    <p class="lead text-center text-md-start text-shadow-body mb-5 d-flex justify-content-sm-center justify-content-md-start">
                                        <span class="col-12 col-sm-10 col-md-8 col-xxl-7">Where every sip, every aroma, and every moment finds its delight, ensuring your coffee experience is always rich and unforgettable..</span>
                                    </p>
                                    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center justify-content-md-start">
                                        <h1><a href="MainController?action=Search_Product&searchProduct=" class="btn btn-accent bsb-btn-2xl btn-outline-darkx">Order Now</a></h1> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Main -->
        <main id="main">
            <!-- Card 5 - Product Component -->
            <section class="pb-3 pb-md-5 pb-xl-8">
                <div class="container">
                    <div class="row justify-content-md-center">
                        <div class="col-12 col-md-10 col-lg-8 col-xl-7 col-xxl-6">
                            <h2 class="mb-4 display-5 text-center">Our Products</h2>
                            <p class="text-secondary mb-5 text-center lead fs-4">Our menu features a wide variety of top-quality coffee beans, meticulously curated to satisfy the tastes of coffee enthusiasts at every level, from casual drinkers to connoisseurs.</p>
                            <hr class="w-50 mx-auto mb-5 mb-xl-9 border-dark-subtle">
                        </div>
                    </div>
                </div>
                <div class="container overflow-hidden">
                    <div class="row gy-4 gy-xxl-5">
                        <div class="toast-container" id="toastContainer"></div>
                        <c:if test="${requestScope.LIST_8PRODUCT != null}">
                            <c:if test="${ not empty requestScope.LIST_8PRODUCT}">
                                <c:forEach var="product" items="${requestScope.LIST_8PRODUCT}" varStatus="status">
                                    <c:if test="${product.status}">

                                        <div class="col-12 col-md-6 col-lg-4 col-xxl-3">
                                            <div class="card text-center border-dark overflow-hidden">
                                                <div class="card-body p-5 position-relative">
                                                    <figure class="m-0 p-0">
                                                        <img class="img-fluid" loading="lazy" src="img/${product.productName}.png" alt="${product.productName}">
                                                        <figcaption class="mb-0 mt-4 p-0">
                                                            <h4 class="mb-2">${product.productName}</h4>
                                                            <p class="d-flex justify-content-center align-items-center gap-2 mb-0">
                                                                <span class="text-primary"></span>
                                                            </p>
                                                        </figcaption>                                                       
                                                    </figure>

                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </c:if>

                    </div>
                </div>
            </section>   
        </main>

        <c:import url="components/footer.jsp" />

        <script src="Javascript/userShopping.js"></script>
       

        <!-- BSB Body End -->
    </body>

</html>
