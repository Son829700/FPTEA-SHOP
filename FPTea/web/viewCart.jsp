<%-- 
    Document   : viewCart
    Created on : Jun 13, 2024, 8:36:42 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="sample.product.ProductDTO"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Document Title, Description, and Author -->
        <title>FPTEA CART</title>
        <meta name="description" content="FPTEA SHOP COFFEE">
        <link rel="icon" type="image/png" sizes="512x512" href="img/FPT.svg.png">
        <!-- google font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
        <!-- fontawesome -->
        <link rel="stylesheet" href="assets/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <!-- animate css -->
        <link rel="stylesheet" href="assets/css/animate.css">
        <!-- mean menu css -->
        <link rel="stylesheet" href="assets/css/meanmenu.min.css">
        <!-- main style -->
        <link rel="stylesheet" href="Css/styleUserShopping.css">
        <link rel="stylesheet" href="assets/css/main.css">
        <!-- responsive -->
        <link rel="stylesheet" href="assets/css/responsive.css">

    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID != 'US'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>   
        <c:import url="components/header.jsp" />    
        <!-- INFROMATION-section -->
        <section class="py-4 py-md-5 py-xl-8">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="container-fluid border border-dark bsb-tpl-bg-gradient-1x">
                            <div class="row justify-content-md-center align-items-center">
                                <div class="col-12 col-md-11 col-xl-10">
                                    <div class="page-header-wrapper py-3 py-md-5 py-xl-8">
                                        <h2 class="display-3 text-center fw-bold mb-3 mb-xl-4">Your cart</h2>
                                        <h2 class="lead text-center m-0 d-flex justify-content-sm-center text-danger display-5 text-center fw-bold mb-3 mb-xl-4">
                                            ${requestScope.CART_MESSAGE}
                                        </h2>
                                        <p class="lead text-center m-0 d-flex justify-content-sm-center">
                                            <span class="col-12 col-sm-11 col-lg-8 col-xl-7 col-xxl-6"> <a href="MainController?action=Search_Product&searchProduct=" class="boxed-btn">Continue Shopping</a></span>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end INFROMATION section -->

        <c:if test="${sessionScope.CART != null}">
            <c:if test="${not empty sessionScope.CART}">
                <!-- cart -->
                <div class="py-4 py-md-5 py-xl-8">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8 col-md-12">
                                <div class="cart-table-wrap">
                                    <table class="cart-table">
                                        <thead class="cart-table-head">
                                            <tr class="table-head-row">
                                                <th class="product-remove"></th>
                                                <th class="product-image">Product Image</th>
                                                <th class="product-name">Name</th>
                                                <th class="product-price">Price</th>
                                                <th class="product-quantity">Quantity</th>
                                                <th class="product-total">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <form action="MainController" method="POST" class="form-inline">
                                            <c:forEach var="product" varStatus="counter" items="${sessionScope.CART.cart.values()}">                                        
                                                <c:set var="total" value="${total+product.price*product.quantity}"></c:set>
                                                    <tr class="table-body-row">
                                                        <td class="product-remove"><a href="MainController?action=Remove&productID=${product.productID}"><i class="far fa-window-close"></i></a></td>
                                                    <td class="product-image"><img src="img/${product.productName}.png" alt=""></td>
                                                    <td class="product-name">${product.productName}</td>
                                                    <td class="product-price">$${product.price}</td>
                                                    <td class="product-quantity">
                                                        <input type="number" value="${product.quantity}" min="1" name="quantity">
                                                        <input type="hidden" value="${product.productID}" name="productID">
                                                    </td>
                                                    <td class="product-total">$${product.price*product.quantity}</td>
                                                </tr> 
                                            </c:forEach>
                                            </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="col-lg-4">
                                <div class="total-section">
                                    <table class="total-table">
                                        <thead class="total-table-head">
                                            <tr class="table-total-row">
                                                <th>Total</th>
                                                <th>Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="total-data">
                                                <td><strong>Subtotal: </strong></td>
                                                <td>$${total}</td>
                                            </tr>
                                            <tr class="total-data">
                                                <td><strong>Shipping: </strong></td>
                                                <td>$2</td>
                                            </tr>
                                            <tr class="total-data">
                                                <td><strong>Total: </strong></td>
                                                <td>$${total+2}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <div class="cart-buttons m-2">
                                        <input type="email" name="email" class="form-control form-inline w-50" placeholder="Enter email to checkout"/>
                                        <input type="submit" name="action" value="Checkout"/>
                                        <input type="submit" name="action" value="Update Cart" class="m-2"/>                                           
                                        <input type="hidden" name="total" value="${total}"/> 
                                        </form>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
                <!-- end cart -->                   
            </c:if>
        </c:if>

        <c:import url="components/footer.jsp" />


    </body>
</html>
