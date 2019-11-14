<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>About</title>
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
                            <h2>About Us</h2>
                            <p>In the history of modern astronomy, there is probably no one greater leap forward than
                                the
                                building and launch of the space telescope known as the Hubble.</p>
                            <div class="page_link">
                                <a href="app/">Home</a>
                                <a href="app/about-us">About</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================ Start Department Area =================-->
    <div class="department_area section_gap">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 text-center">
                    <img class="img-fluid" src="ui/img/about-img.png" alt="">
                </div>

                <div class="offset-lg-1 col-lg-5">
                    <div class="dpmt_right">
                        <h1>Over 2500 Courses from 5 Platform</h1>
                        <p>There is a moment in the life of any aspiring astronomer that it is time to buy that first
                            telescope. It’s
                            exciting to think about setting up your own viewing station. In the life of any aspiring
                            astronomer that it is
                            time to buy that first telescope. It’s exciting to think about setting up your own viewing
                            station.</p>
                        <p>It’s exciting to think about setting up your own viewing station. In the life of any
                            aspiring astronomer that
                            it is time to buy that first telescope exciting is time to buy that first.</p>
                        <a href="#" class="primary-btn text-uppercase">Explore Courses</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================ End Department Area =================-->

    <c:import url="components/instruction.jsp"/>

    <c:import url="components/department.jsp"/>
    
    <c:import url="components/fact.jsp"/>
    
    <c:import url="components/testimonial.jsp"/>

    <c:import url="components/footer.jsp"/>

    <c:import url="components/scripts.html"/>
</body>

</html>