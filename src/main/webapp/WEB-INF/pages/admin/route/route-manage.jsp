<%-- 
    Document   : route-manage
    Created on : May 3, 2023, 8:08:48 PM
    Author     : Nguyen0210
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-secondary">Quản Lý Tuyến Xe Khách</h1>
<c:url value="/admin/route-manage" var="action"/>
<c:if test="${errMsg != null}">${errMsg}</c:if>

<form:form method="post" action="${action}" enctype="multipart/form-data"  modelAttribute="route">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name"
                    id="name" placeholder="Tên tuyến xe" name="name"/>
        <label for="name">Tên tuyến xe</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="price"
                    id="price" placeholder="Giá tuyến" name="price"/>
        <label for="name">Giá tuyến:</label>
    </div>


    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" path="startingPoint" id="startingPoint" name="startingPoint">
            <c:forEach items="${stations}" var="s">
                <c:choose>
                    <c:when test="${route.startingPoint.id == s.id}" >
                        <option value="${s.id}" selected>${s.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}" >${s.name}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="startingPoint" class="form-label">Điểm xuất phát:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" path="endingPoint" id="endingPoint" name="endingPoint">
            <c:forEach items="${stations}" var="s">
                <c:choose>
                    <c:when test="${route.endingPoint.id == s.id}" >
                        <option value="${s.id}" selected>${s.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}" >${s.name}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="endingPoint" class="form-label">Điểm đến:</label>
    </div>

 
    <div class="form-floating mb-3 mt-3">
        <c:choose>
            <c:when test="${route.id > 0}">
                <form:hidden path="id" />
             
                <input type="submit" value="Cập nhập tuyến" class="btn btn-success"/>
            </c:when>
            <c:otherwise>
                <input type="submit" value="Thêm tuyến xe" class="btn btn-info"/>
              
            </c:otherwise>
        </c:choose>

    </div>
</form:form>
<table class="table">
    <thead>
        <tr>
          
            <th scope="col">Id</th>
            <th scope="col">Tên Tuyến Xe</th>
            <th scope="col">Giá Tuyến Xe</th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${routes}" var="r">
            <tr id="route${r.id}">
                
                <td>${r.id}</td>
                <td>${r.name}</td>
                <td>${r.price}</td>
                
                <td>
                    <c:url value="/api/route/${r.id}" var="endpoint"/>
                    <input type="button" onclick="deleteRoute('${endpoint}',${r.id})" value="Xóa Tuyến" class="btn btn-danger"/>
                    <a href="<c:url value="/admin/route-manage/${r.id}" />" class="btn btn-info">Cập Nhập Tuyến</a>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>


<script src="<c:url value="/js/route.js" />"></script>