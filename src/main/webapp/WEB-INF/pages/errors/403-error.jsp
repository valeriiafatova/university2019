<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageTag" tagdir="/WEB-INF/tags" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<head>
    <title>Forbidden</title>
    <c:import url="../components/head.jsp"/>
</head>
<c:import url="../components/header.jsp"/>
<body>

<pageTag:banner head="error.403.banner.head" content="error.403.banner.content" 
                level1="banner.link.home"/>

<section class="sample-text-area">

</section>

<c:import url="../components/footer.jsp"/>
<c:import url="../components/scripts.html"/>

</body>
</html>