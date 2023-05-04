<%-- 
    Document   : trip-manage
    Created on : May 3, 2023, 3:21:03 PM
    Author     : Nguyen0210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center text-secondary">Quản Lý Chuyến Xe</h2>
<c:url value="/admin/trip-manage" var="action"/>
<form:form method="post" action="${action}" modelAttribute="trip">

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name"
                    id="name" placeholder="Tên tuyến xe" name="name"/>
        <label for="name">Tên tuyến</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="datetime-local" class="form-control" path="startTime"
                    id="startTime" placeholder="thời gian bắt đầu" name="startTime"/>
        <label for="name">Thời gian bắt đầu: </label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="datetime-local" class="form-control" path="endTime"
                    id="endTime" placeholder="thời gian bắt đầu" name="endTime"/>
        <label for="name">Thời gian kết thúc: </label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="emptySeats"
                    id="emptySeats" placeholder="Số chổ trống" name="emptySeats"/>
        <label for="emptySeats">Số chổ trống: </label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="description"
                    id="description" placeholder="Mô tả" name="description"/>
        <label for="emptySeats">Mô tả: </label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="unitprice"
                    id="unitprice" placeholder="Đơn giá" name="unitprice"/>
        <label for="emptySeats">Đơn giá: </label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="submit" value="Thêm xe" class="btn btn-success"/>
    </div>
</form:form>

