<%-- 
    Document   : bus
    Created on : May 3, 2023, 9:37:02 AM
    Author     : Nguyen0210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-secondary">Quản Lý Xe Khách</h1>
<c:url value="/admin/bus-manage" var="action"/>
<c:if test="${errMsg != null}">${errMsg}</c:if>

<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="bus">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name"
                    id="name" placeholder="Tên sản phẩm" name="name"/>
        <label for="name">Tên xe</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="numberplates"
                    id="numberplates" placeholder="Biển số xe" name="numberplates"/>
        <label for="name">Biển định danh xe:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="description"
                    id="description" placeholder="Mô tả cho xe" name="description"/>
        <label for="name">Mô tả xe:</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" path="categoryId" id="categoryId" name="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${bus.categoryId.id == c.id}" >
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}" >${c.name}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Loại xe:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file"
                    id="file"  name="file"/>
        <label for="name">Ảnh xe: </label>
    </div>
    <c:if test="${bus.image != null}">
        <div class="form-floating mb-3 mt-3">
            <<img src="${bus.image}" width="120" alt="alt"/>
        </div>
    </c:if>

    <div class="form-group mb-3 mt-3">
        <label for="active">Trạng thái xe:</label>
        <form:select
            id="active"
            name="active"
            class="custom-select mb-3 form-control"
            path="active"
            >
            <form:option value="1" label="Hoạt động" />
            <form:option value="0" label="Chưa hoạt động" />
        </form:select>
    </div>
    <div class="form-floating mb-3 mt-3">
        <c:choose>
            <c:when test="${bus.id > 0}">
                <form:hidden path="id" />
                <form:hidden path="image" />
                <input type="submit" value="Cập nhập xe" class="btn btn-success"/>
            </c:when>
            <c:otherwise>
                <input type="submit" value="Thêm xe" class="btn btn-info"/>
            </c:otherwise>
        </c:choose>

    </div>
</form:form>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Ảnh Nhà Xe</th>
            <th scope="col">Id</th>
            <th scope="col">Tên Nhà Xe</th>
            <th scope="col">Biển Định Danh</th>
            <th scope="col">Mô Tả</th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${buses}" var="b">
            <tr id="bus${b.id}">
                <td>
                    <img src="${b.image}" alt="alt" width="200"/>
                </td>
                <td>${b.id}</td>
                <td>${b.name}</td>
                <td>${b.numberplates}</td>
                <td style="width: 300px">${b.description}</td>
                <td>
                    <c:url value="/api/bus/${b.id}" var="endpoint"/>
                    <input type="button" onclick="deleteBus('${endpoint}',${b.id})" value="Xóa" class="btn btn-danger"/>
                    <a href="<c:url value="/admin/bus-manage/${b.id}" />" class="btn btn-info">Cập nhập</a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>


<script src="<c:url value="/js/bus.js" />"></script>