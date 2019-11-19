<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Courses</title>
    <c:import url="components/head.jsp"/>

</head>

<body>

<c:import url="components/header.jsp"/>


<!--================Home Banner Area =================-->
<section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
        <div class="overlay"></div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="banner_content text-center">
                        <h2>Courses</h2>
                        <p>In the history of modern astronomy, there is probably no one greater leap forward than
                            the
                            building and launch of the space telescope known as the Hubble.</p>
                        <div class="page_link">
                            <a href="">Home</a>
                            <a href="static/courses.jsp">Courses</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Home Banner Area =================-->

<c:import url="components/popularCourses.jsp"/>

<c:import url="components/footer.jsp"/>

<c:import url="components/scripts.html"/>
</body>

</html>