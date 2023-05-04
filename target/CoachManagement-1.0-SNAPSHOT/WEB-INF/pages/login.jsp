<%-- 
    Document   : login
    Created on : May 2, 2023, 9:40:12 PM
    Author     : Nguyen0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-secondary">Đăng Nhập</h1>


<c:url value="/login" var="action"/>
<form method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        <label for="username">Tên đăng nhập</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        <label for="password">Mật khẩu</label>
    </div>
    <input type="submit" value="Đăng nhập" class="btn btn-secondary"/>
</form>