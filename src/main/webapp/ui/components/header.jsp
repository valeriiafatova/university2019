<%--
  Created by IntelliJ IDEA.
  User: Valeriia_Fatova
  Date: 11/14/2019
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--================ Start Header Menu Area =================-->
<header class="header_area">
    <div class="header-top">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-sm-6 col-4 header-top-left">
                    <a href="tel:+9530123654896">
                        <span class="lnr lnr-phone"></span>
                        <span class="text">
								<span class="text">+953012 3654 896</span>
							</span>
                    </a>
                    <a href="mailto:support@colorlib.com">
                        <span class="lnr lnr-envelope"></span>
                        <span class="text">
								<span class="text">support@colorlib.com</span>
							</span>
                    </a>
                </div>
                
                <div class="col-lg-6 col-sm-6 col-8 header-top-right">
                    <a href="language?locale=en" class="text-uppercase">en</a>
                    <a href="language?locale=de" class="text-uppercase">de</a>
                    <a href="language?locale=ru" class="text-uppercase">ru</a>
                    <a href="#" class="text-uppercase">Login</a>
                </div>
            </div>
        </div>
    </div>

    <div class="main_menu">
        <div class="search_input" id="search_input_box">
            <div class="container">
                <form class="d-flex justify-content-between" method="" action="">
                    <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                    <button type="submit" class="btn"></button>
                    <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
                </form>
            </div>
        </div>

        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href=""><img src="ui/img/logo.png" alt=""></a>
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                    <ul class="nav navbar-nav menu_nav ml-auto">
                        <li class="nav-item active"><a class="nav-link" href="">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="about-us">About</a></li>
                        <li class="nav-item submenu dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                               aria-expanded="false">Pages</a>
                            <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link" href="course">Courses</a></li>
                                <li class="nav-item"><a class="nav-link" href="course-details">Course Details</a></li>
                            </ul>
                        </li>
                        <li class="nav-item submenu dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                               aria-expanded="false">Blog</a>
                            <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link" href="blog">Blog</a></li>
                                <li class="nav-item"><a class="nav-link" href="single-blog">Blog Details</a></li>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="contact">Contact</a></li>
                        <li class="nav-item">
                            <a href="" class="nav-link search" id="search">
                                <i class="lnr lnr-magnifier"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>
<!--================ End Header Menu Area =================-->
</body>
</html>
