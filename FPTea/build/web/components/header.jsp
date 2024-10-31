<%-- 
    Document   : header
    Created on : Jul 5, 2024, 9:42:05 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required Meta Tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Document Title, Description, and Author -->
        <title>Header</title>
        <meta name="description" content="FPTEA COFFEE">
        <meta name="author" content="BootstrapBrain">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="Css/styleUserShopping.css">
        <link rel="icon" type="image/png" sizes="512x512" href="img/FPT.svg.png">
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
    </head>
    <body>
        <!-- Header -->

        <header id="header" class="bsb-tpl-bg-50 sticky-top bsb-spacer-top-3 bsb-spacer-top-md-5 bsb-spacer-top-xl-6 bsb-tpl-header-sticky bsb-tpl-header-sticky-animation">

            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <!-- Navbar 1 - Bootstrap Brain Component -->
                        <nav class="navbar navbar-expand-lg bsb-navbar bsb-navbar-hover bsb-navbar-caret bsb-tpl-navbar-sticky bg-white border border-dark px-xl-3" data-bsb-sticky-target="#header">
                            <div class="container">
                                <a class="navbar-brand" href="MainController?action=Back_Home">
                                    <img src="img/FPT.svg.png" class="bsb-tpl-logo" alt="">
                                </a>
                                <button class="navbar-toggler border-0" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z" />
                                    </svg>
                                </button>       

                                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                                    <div class="offcanvas-header">
                                        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                                    </div>
                                    <div class="offcanvas-body">
                                        <ul class="navbar-nav justify-content-end flex-grow-1" >
                                            <div class="navigation-card">
                                                <form action="MainController" method="POST">
                                                    <li class="nav-item">
                                                        <div class="input-wrapper">
                                                            <button class="icon tab" type="button"> 
                                                                <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                                                <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"/>
                                                                </svg>
                                                            </button>
                                                            <input placeholder="search.." class="input" name="searchProduct" type="text" value="${param.searchProduct}">
                                                            <input type="hidden"name="action" value="Search_Product"/> 
                                                        </div>
                                                    </li>
                                                </form>
                                                <li class="nav-item">
                                                    <a href="MainController?action=Back_Home" class="tab">
                                                        <svg
                                                            class="svgIcon"
                                                            viewBox="0 0 104 100"
                                                            fill="none"
                                                            xmlns="http://www.w3.org/2000/svg"
                                                            >
                                                        <path
                                                            d="M100.5 40.75V96.5H66V68.5V65H62.5H43H39.5V68.5V96.5H3.5V40.75L52 4.375L100.5 40.75Z"
                                                            stroke="black"
                                                            stroke-width="7"
                                                            ></path>
                                                        </svg>
                                                    </a>
                                                </li>                                         
                                                <li class="nav-item">
                                                    <a href="MainController?action=View" class="tab">
                                                        <?xml version="1.0" encoding="utf-8"?><svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 122.9 107.5" style="enable-background:new 0 0 122.9 107.5" xml:space="preserve"><g><path d="M3.9,7.9C1.8,7.9,0,6.1,0,3.9C0,1.8,1.8,0,3.9,0h10.2c0.1,0,0.3,0,0.4,0c3.6,0.1,6.8,0.8,9.5,2.5c3,1.9,5.2,4.8,6.4,9.1 c0,0.1,0,0.2,0.1,0.3l1,4H119c2.2,0,3.9,1.8,3.9,3.9c0,0.4-0.1,0.8-0.2,1.2l-10.2,41.1c-0.4,1.8-2,3-3.8,3v0H44.7 c1.4,5.2,2.8,8,4.7,9.3c2.3,1.5,6.3,1.6,13,1.5h0.1v0h45.2c2.2,0,3.9,1.8,3.9,3.9c0,2.2-1.8,3.9-3.9,3.9H62.5v0 c-8.3,0.1-13.4-0.1-17.5-2.8c-4.2-2.8-6.4-7.6-8.6-16.3l0,0L23,13.9c0-0.1,0-0.1-0.1-0.2c-0.6-2.2-1.6-3.7-3-4.5 c-1.4-0.9-3.3-1.3-5.5-1.3c-0.1,0-0.2,0-0.3,0H3.9L3.9,7.9z M96,88.3c5.3,0,9.6,4.3,9.6,9.6c0,5.3-4.3,9.6-9.6,9.6 c-5.3,0-9.6-4.3-9.6-9.6C86.4,92.6,90.7,88.3,96,88.3L96,88.3z M53.9,88.3c5.3,0,9.6,4.3,9.6,9.6c0,5.3-4.3,9.6-9.6,9.6 c-5.3,0-9.6-4.3-9.6-9.6C44.3,92.6,48.6,88.3,53.9,88.3L53.9,88.3z M33.7,23.7l8.9,33.5h63.1l8.3-33.5H33.7L33.7,23.7z"/></g></svg>
                                                    </a>
                                                </li>
                                                <li class="nav-item dropdown">
                                                    <a href="#" class="tab" class="nav-link dropdown-toggle" href="#!" id="blogDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                        <svg
                                                            width="104"
                                                            height="100"
                                                            viewBox="0 0 104 100"
                                                            fill="none"
                                                            xmlns="http://www.w3.org/2000/svg"
                                                            >
                                                        <rect
                                                            x="21.5"
                                                            y="3.5"
                                                            width="60"
                                                            height="60"
                                                            rx="30"
                                                            stroke="black"
                                                            stroke-width="7"
                                                            ></rect>
                                                        <g clip-path="url(#clip0_41_27)">
                                                        <mask
                                                            id="mask0_41_27"
                                                            style="mask-type:luminance"
                                                            maskUnits="userSpaceOnUse"
                                                            x="0"
                                                            y="61"
                                                            width="104"
                                                            height="52"
                                                            >
                                                            <path
                                                                d="M0 113C0 84.2812 23.4071 61 52.1259 61C80.706 61 104 84.4199 104 113H0Z"
                                                                fill="white"
                                                                ></path>
                                                        </mask>
                                                        <g mask="url(#mask0_41_27)">
                                                        <path
                                                            d="M-7 113C-7 80.4152 19.4152 54 52 54H52.2512C84.6973 54 111 80.3027 111 112.749H97C97 88.0347 76.9653 68 52.2512 68H52C27.1472 68 7 88.1472 7 113H-7ZM-7 113C-7 80.4152 19.4152 54 52 54V68C27.1472 68 7 88.1472 7 113H-7ZM52.2512 54C84.6973 54 111 80.3027 111 112.749V113H97V112.749C97 88.0347 76.9653 68 52.2512 68V54Z"
                                                            fill="black"
                                                            ></path>
                                                        </g>
                                                        </g>
                                                        <defs>
                                                        <clipPath id="clip0_41_27">
                                                            <rect
                                                                width="104"
                                                                height="39"
                                                                fill="white"
                                                                transform="translate(0 61)"
                                                                ></rect>
                                                        </clipPath>
                                                        </defs>
                                                        </svg>
                                                    </a>
                                                    <ul class="dropdown-menu border-0 shadow bsb-zoomIn" aria-labelledby="blogDropdown">
                                                        <li><a class="dropdown-item" href="MainController?action=Profile_Page"><svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24">
                                                                <path fill-rule="evenodd" d="M12 20a7.966 7.966 0 0 1-5.002-1.756l.002.001v-.683c0-1.794 1.492-3.25 3.333-3.25h3.334c1.84 0 3.333 1.456 3.333 3.25v.683A7.966 7.966 0 0 1 12 20ZM2 12C2 6.477 6.477 2 12 2s10 4.477 10 10c0 5.5-4.44 9.963-9.932 10h-.138C6.438 21.962 2 17.5 2 12Zm10-5c-1.84 0-3.333 1.455-3.333 3.25S10.159 13.5 12 13.5c1.84 0 3.333-1.455 3.333-3.25S13.841 7 12 7Z" clip-rule="evenodd"/>
                                                                </svg>
                                                                Profile
                                                            </a></li>
                                                        <li><a class="dropdown-item" href="MainController?action=Logout"><svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                                                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M20 12H8m12 0-4 4m4-4-4-4M9 4H7a3 3 0 0 0-3 3v10a3 3 0 0 0 3 3h2"/>
                                                                </svg>
                                                                Logout</a></li>
                                                    </ul>
                                                </li> 
                                            </div>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <script src="Javascript/userShopping.js"></script>
    </body>
</html>
