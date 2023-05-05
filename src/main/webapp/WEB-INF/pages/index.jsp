<%-- 
    Document   : index
    Created on : May 1, 2023, 12:31:22 PM
    Author     : Nguyen0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<section class="container my-4">
    <div class="alert alert-danger alert-dismissible fade show" role="alert" id="alertDuplicate" style="display:none">

        Vui lòng chọn hai địa điểm khác nhau!
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <form class="row justify-content-center align-items-center my-2"  onsubmit="return checkDuplicateOptions()">
        <div class="col-md-3">
            <div class="form-floating">
                <select class="form-select" id="start" name="start" onchange="removeDuplicateOptions()">
                    <c:forEach items="${location}" var="l">
                        <option value="${l.id}">${l.nameLocation}</option>
                    </c:forEach>

                </select>
                <label for="sel1" class="form-label fw-bold">Chọn nơi đi:</label>
            </div>
        </div>
        <div class="col-md-1 text-center"><i class="fa-2x fas fa-arrow-right mx-2"></i></div>
        <div class="col-md-3">
            <div class="form-floating">
                <select class="form-select" id="end" name="end" onchange="removeDuplicateOptions()">
                    <c:forEach items="${location}" var="l">
                        <option value="${l.id}" <c:if test="${l.id == '2'}">selected="selected"</c:if> >${l.nameLocation}</option>
                    </c:forEach>
                </select>
                <label for="sel1" class="form-label fw-bold">Chọn nơi đến:</label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-floating">
                <input name="date" class="form-control" id="datePicker" type="date" required>
                <label for="sel1" class="form-label fw-bold">Chọn ngày đi:</label>
            </div>
        </div>
        <div class="col-md-2">
            <div class="form-floating">
                <button type="submit" class="btn btn-secondary btn-lg">Tìm chuyến</button>
            </div>
        </div>
    </form>
    <div class="card container">
        <div class="row no-gutters">
            <div class="col-md-4">
                <img src="https://res.cloudinary.com/dif0oia5b/image/upload/v1683082945/xe-khach.jpg_xl04qt.jpg" class="card-img" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">Tên xe: Nhà xe Hoàng Huy</h5>
                    <p class="card-text">Nơi đi: <span> Hà Nội</span></p>
                    <p class="card-text">Nơi đến: <span>TP Hồ Chí Minh</span></p>
                    <p class="card-text">Thời gian bắt đầu: <span>05/05/2023 18:30:00</span></p>
                    <p class="card-text">Thời gian kết thúc: <span>06/05/2023 10:00:00</span></p>
                    <p class="card-price">Giá vé: <span>600,000 VNĐ</span></p>
                    <div class="card-seats">
                        <span>Số chỗ trống: </span><span>42</span>
                    </div>
                    <div class="card-buttons text-right">
                        <a href="#" class="btn btn-primary">Xem chi tiết</a>
                        <se:authorize access="isAuthenticated()">
                        <a href="#" class="btn btn-success">Đặt vé ngay</a>
                        </se:authorize>
                        <se:authorize access="!isAuthenticated()">
                            <a href="<c:url value="/login"/>" class="btn btn-secondary">Đăng nhập để đặt vé</a>
                        </se:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
<script>
    window.onload = function () {
        var date = new Date();
        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();
        if (month < 10)
            month = "0" + month;
        if (day < 10)
            day = "0" + day;
        var today = year + "-" + month + "-" + day;
        let datePicker = document.getElementById('datePicker');
        datePicker.value = today;
        datePicker.setAttribute("min", today);
    };
    function checkDuplicateOptions() {
        var startSelect = document.getElementById("start");
        var endSelect = document.getElementById("end");
        var alertDuplicate = document.getElementById("alertDuplicate");
        if (startSelect.value === endSelect.value) {
            alertDuplicate.style.display = "block"; // Hiển thị alert box
            return false;
        }

        alertDuplicate.style.display = "none"; // Ẩn alert box (nếu đã hiển thị trước đó)
        return true;
    }

</script>