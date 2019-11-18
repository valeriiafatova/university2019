<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>

<head>
    <title>University</title>
    <c:import url="components/head.jsp"/>
</head>

<body>
<c:import url="components/header.jsp"/>
<!--================ Start Home Banner Area =================-->
<section class="home_banner_area">
    <div class="banner_inner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="banner_content">
                        <h2>
                            <fmt:message key="home.banner.content"/><br>
                            Courses on the Web
                        </h2>
                        <p>
                            In the history of modern astronomy, there is probably no one greater leap forward than the
                            building and launch
                            of
                            the space telescope known as the Hubble.
                        </p>
                        <div class="search_course_wrap">
                            <form action="" class="form_box d-flex justify-content-between w-100">
                                <input type="text" placeholder="Search Courses" class="form-control" name="username"
                                       onfocus="this.placeholder = ''"
                                       onblur="this.placeholder = 'Search Courses'">
                                <button type="submit" class="btn search_course_btn">Search</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================ End Home Banner Area =================-->

<c:import url="components/feature.jsp"/>

<c:import url="components/department.jsp"/>

<c:import url="components/popularCourses.jsp"/>

<c:import url="components/fact.jsp"/>

<c:import url="components/registration.jsp"/>

<c:import url="components/testimonial.jsp"/>

<c:import url="components/footer.jsp"/>

<div id="login-modal" class="modal fade " role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
            </div>
            <form id="loginForm" name="login" role="form" action="login" method="post">
                <div class="modal-body mx-3">
                    <div class="input-group-icon mt-10">
                        <div class="icon"><i class="fa fa-user"></i>
                        </div>
                        <input type="text" name="login" class="single-input">
                        <label data-error="wrong" data-success="right" for="login">Your email</label>
                    </div>

                    <div class="input-group-icon mt-10">
                        <div class="icon"><i class="fa fa-lock"></i></div>
                        <input type="password" name="password" class="single-input">
                        <label data-error="wrong" data-success="right" for="password">Your password</label>
                    </div>
                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <button class="primary-btn text-uppercase enroll">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<c:import url="components/scripts.html"/>
<script>
	$(".login").click(function(e){
	    e.preventDefault();
	    console.log("click on login");
        $('#login-modal').fadeIn()
        $('.modal').modal('hide');
        $('#login-modal').modal('show');
    })
    
</script>
</body>

</html>