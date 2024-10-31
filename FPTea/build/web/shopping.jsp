<%-- 
    Document   : order
    Created on : Jul 3, 2024, 2:58:25 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <head>
        <!-- Required Meta Tags -->
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Document Title, Description, and Author -->
        <title>FPTEA COFFEE</title>
        <meta name="description" content="FPTEA SHOP COFFEE">
         <link rel="icon" type="image/png" sizes="512x512" href="img/FPT.svg.png">

        <!-- Google Fonts Files -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.4/components/paginations/pagination-1/assets/css/pagination-1.css" />
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">


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
        <c:if test="${requestScope.MESSAGE != null}">
      
                <div id="auto-dismiss-alert" class="alert alert-success m-2 floating-alert alert-dismissible" role="alert">
                    ${requestScope.MESSAGE}
                    <button type="button" class="btn-close" aria-label="close" data-bs-dismiss="alert"></button>
                </div>
        </c:if>
        <!-- Main -->
        <main id="main">

            <!-- Product -->
            <section class="py-3 py-md-5 py-xl-8 bg-white">
                <div class="container overflow-hidden">
                    <div class="row gy-4 gy-xxl-5">
                        <c:if test="${requestScope.LIST_PRODUCT_BY_PAGE != null}">
                            <c:if test="${ not empty requestScope.LIST_PRODUCT_BY_PAGE}">
                                <c:forEach var="product" items="${requestScope.LIST_PRODUCT_BY_PAGE}" varStatus="status">
                                    <c:if test="${product.status}">
                                        <div class="col-12 col-md-6 col-lg-4 col-xxl-3">
                                            <div class="card text-center border-dark overflow-hidden">
                                                <div class="card-body p-5 position-relative">
                                                    <figure class="m-0 p-0">
                                                        <img class="img-fluid" loading="lazy" src="img/${product.productName}.png" alt="${product.productName}">
                                                        <figcaption class="mb-0 mt-4 p-0">
                                                            <h4 class="mb-2">${product.productName}</h4>
                                                            <p class="d-flex justify-content-center align-items-center gap-2 mb-0">
                                                                <span class="text-primary">$${product.price}</span>
                                                            </p>
                                                        </figcaption>
                                                    </figure>
                                                    <form action="MainController" method="POST" class="form">
                                                        <input type="number" name="quantity" value="1" min="1" class="form-control m-1"/>                                                   
                                                        <button type="submit" name="action" value="Add" class="btn btn-accent mt-4 d-flex align-items-center justify-content-center gap-2 form-control m-1">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus" viewBox="0 0 16 16">
                                                            <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9z" />
                                                            <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1zm3.915 10L3.102 4h10.796l-1.313 7zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0m7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0" />
                                                            </svg>
                                                            <span>Add to cart</span>
                                                        </button>
                                                        <input type="hidden" name="productID" value="${product.productID}"/>
                                                        <input type="hidden" name="productName" value="${product.productName}"/>
                                                        <input type="hidden" name="price" value="${product.price}"/>
                                                        <input type="hidden" name="searchProduct" value="${param.searchProduct}"/>
                                                        <input type="hidden" name="page" value="${requestScope.PAGE}"/>
                                                    </form>
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

            <!--PAGING-->
            <section class="pb-4 pb-md-5">
                <div class="container">
                    <!-- Pagination 1 - Bootstrap Brain Component -->
                    <section class="bg-light py-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <nav aria-label="BSB Pagination 1 Example">
                                        <ul class="pagination bsb-pagination-1 pagination-lg justify-content-center">
                                            <c:set var="page" value="${requestScope.PAGE}"></c:set>
                                            <c:if test="${page!=1}">
                                                <li class="page-item"><a class="page-link" href="MainController?action=Search_Product&searchProduct=${param.searchProduct}&page=${page-1}">Previous</a></li>
                                                </c:if> 
                                                <c:forEach begin="1" end="${requestScope.NUMBER_OF_PAGE}" var="i">
                                                <li class="page-item ${i==page?"active":""}"><a class="page-link" href="MainController?action=Search_Product&searchProduct=${param.searchProduct}&page=${i}">${i}</a></li>
                                                </c:forEach>
                                                <c:if test="${page!=requestScope.NUMBER_OF_PAGE}">
                                                <li class="page-item"><a class="page-link" href="MainController?action=Search_Product&searchProduct=${param.searchProduct}&page=${page+1}">Next</a></li>
                                                </c:if> 
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </section>
        </main>

        <!-- Footer Component -->
        <c:import url="components/footer.jsp" />



        <!-- Javascript Files: Vendors -->
        <script src="https://unpkg.com/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.bundle.min.js"></script>

        <!-- Javascript Files: Controllers -->
        <script src="Javascript/userShopping.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {               
                setTimeout(function () {
                    var alertElement = document.getElementById('auto-dismiss-alert');
                    alertElement.classList.add('hidden');
                }, 3000);
            });
        </script>
        <!-- BSB Body End -->
    </body>

</html>

