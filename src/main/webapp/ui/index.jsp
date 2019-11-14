<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
								We Rank the Best <br>
								Courses on the Web
							</h2>
							<p>
								In the history of modern astronomy, there is probably no one greater leap forward than the building and launch
								of
								the space telescope known as the Hubble.
							</p>
							<div class="search_course_wrap">
								<form action="" class="form_box d-flex justify-content-between w-100">
									<input type="text" placeholder="Search Courses" class="form-control" name="username" onfocus="this.placeholder = ''"
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
	<c:import url="components/scripts.html"/>
</body>

</html>