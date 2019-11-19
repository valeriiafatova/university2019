<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<head>
    <title>Title</title>
    <c:import url="components/head.jsp"/>
</head>
<c:import url="components/header.jsp"/>
<!--================Home Banner Area =================-->
<section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
        <div class="overlay"></div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="banner_content text-center">
                        <h2>Registration</h2>
                        <p>Please, provide your details to be able to enroll for course and see your ratings.</p>
                        <div class="page_link">
                            <a href="">Home</a>
                            <a href="register">Registration</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Home Banner Area =================-->

<section class="section-top-border">
    <div class="container col-lg-4">
        ${error}
        <h3 class="mb-30 title_color">Registration Form</h3>
        <form action="register" method="post">
            <div class="mt-10">
                <input type="text" name="first_name" placeholder="First Name" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'First Name'"
                       required class="single-input">
            </div>
            <div class="mt-10">
                <input type="text" name="last_name" placeholder="Last Name" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'Last Name'"
                       required class="single-input">
            </div>
            <div class="input-group-icon mt-10">
                <div class="icon mt-10"><i class="fa fa-user"></i></div>
                <input type="text" name="login" placeholder="Login" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'Login'"
                       required class="single-input">
            </div>
            <div class="input-group-icon mt-10">
                <div class="icon mt-10"><i class="fa fa-lock"></i></div>
                <input type="password" name="password" placeholder="Password" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'Password'"
                       required class="single-input">
            </div>
            <div class="input-group-icon mt-10">
                <div class="icon mt-10"><i class="fa fa-lock"></i></div>
                <input type="password" name="password_confirm" placeholder="Confirm Password"
                       onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'Confirm Password'"
                       required class="single-input">
            </div>
            <div class="mt-25">
                <button type="submit" class="primary-btn text-uppercase enroll">Registration</button>
            </div>
        </form>
    </div>
</section>
<c:import url="components/footer.jsp"/>

<c:import url="components/scripts.html"/>
</body>
</html>
