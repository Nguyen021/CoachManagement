<%-- 
    Document   : header
    Created on : May 2, 2023, 4:43:49 PM
    Author     : Nguyen0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <nav class="navbar navbar-expand-sm bg-secondary navbar-dark " style="height: 70px">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="/CoachManagement/">Coach Manager</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link fw-bold" href="#">Đặt vé xe</a>
                    </li>
                   
                    <se:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/route-manage"/>"> Quản Lý tuyến xe </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href=""<c:url value="/admin/bus-manage"/>">Quản Lý xe</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/trip-manage"/>">Quản Lý chuyến xe</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/stats"/>">Thống kê báo cáo</a>
                        </li>
                    </se:authorize>

                

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login"/>">Đăng Nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Đăng Ký</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>">Chào mừng ${pageContext.session.getAttribute("currentUser").firtName}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout"/>">Đăng Xuất</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
</header>