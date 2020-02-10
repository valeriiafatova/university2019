<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--================ Start Popular Courses Area =================-->
<div class="popular_courses lite_bg">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="main_title">
                    <h2>Popular Courses</h2>
                    <p>There is a moment in the life of any aspiring astronomer that it is time to buy that first
                        telescope. It’s
                        exciting to think about setting up your own viewing station.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- single course -->
            <c:forEach items="${courses}" var="course">
                <div class="col-lg-3 col-md-6">
                    <div class="single_course">
                        <div class="course_head overlay">
                            <img class="img-fluid w-100" src="static/img/courses/trainer1.jpg" alt="">
                            <div class="authr_meta">
                                <img src="static/img/author1.png" alt="">
                                <span>${course.lecturer.name}</span>
                            </div>
                        </div>
                        <div class="course_content">
                            <h4>
                                <a href="courses?course_id=${course.id}">${course.title}</a>
                            </h4>
                            <p>${course.description}</p>
                            <div class="course_meta d-flex justify-content-between">
                                <div>
                                    <span class="meta_info">
                                        <a href="#"><i class="lnr lnr-user"></i>355</a>
                                    </span>
                                    <span class="meta_info">
                                        <a href="#">
                                            <i class="lnr lnr-bubble"></i>35
                                        </a>
                                    </span>
                                </div>
                                <div>
                                    <span class="price">$150</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!--================ End Popular Courses Area =================-->