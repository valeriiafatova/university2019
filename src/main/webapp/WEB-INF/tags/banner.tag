<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ attribute name="head" required="true" type="java.lang.String" %>
<%@ attribute name="content" required="true" type="java.lang.String" %>
<%@ attribute name="level1" required="true" type="java.lang.String" %>
<%@ attribute name="level2" required="false" type="java.lang.String" %>
<%@ attribute name="level3" required="false" type="java.lang.String" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
        <div class="overlay"></div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="banner_content text-center">
                        <h2><fmt:message key="${head}"/></h2>
                            <p><fmt:message key="${content}"/></p>
                        <div class="page_link">
                            <a href=""><fmt:message key="${level1}"/></a>
                        </div>
                        <c:if test="${not empty level2}">
                            <div class="page_link">
                                <a href=""><fmt:message key="${level2}"/></a>
                            </div>
                        </c:if>
                        <c:if test="${not empty level3}">
                            <div class="page_link">
                                <a href=""><fmt:message key="${level3}"/></a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>