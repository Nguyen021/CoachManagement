<%-- 
    Document   : stats
    Created on : May 4, 2023, 5:16:06 PM
    Author     : Nguyen0210
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-secondary">Thống Kê Báo Cáo</h1>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Thống kê báo cáo danh thu</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item "><a class="text-decoration-none text-secondary" href="#">Home</a></li>
                        <li class="breadcrumb-item active fw-bold">Thống kê</li>
                    </ol>
                </div>
            </div>
        </div>
    </section>
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-7">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Danh thu các quý trong năm</h3>

                            <div class="card-tools">
                                <button
                                    type="button"
                                    class="btn btn-tool"
                                    data-card-widget="collapse"
                                    >
                                 
                                </button>
                            </div>
                        </div>
                        <div class="card-body p-0">
                            <table class="table table-striped projects text-center">
                                <thead>
                                    <tr>
                                        <th style="width: 15% ">
                                            Quý (1,2,3,4 -> tháng 1-3, 3-6, 6-9, 9-12)
                                        </th>
                                        <th style="width: 15%">
                                            Tổng Doanh Thu
                                        </th>                                     
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="r" items="${revenueQuarter}">
                                        <tr>
                                            <td>${r[0]}</td>
                                            <td> <fmt:formatNumber value="${r[1]}" type="currency" currencySymbol=""/> VNĐ </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>                
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <form class="my-1">
                        <div class="form-group mb-3">
                            <input type="number" min="2020" 
                                   class="form-control" 
                                   placeholder="Năm ..." name="year" />
                        </div>
                        <input type="submit" value="Lọc dữ liệu" class="btn btn-danger mb-2" />
                    </form>
                    <div class="card card-info">
                        <div class="card-header">
                            <h3 class="card-title">Biểu đồ doanh thu theo quý</h3>

                            <div class="card-tools">
                                <button
                                    type="button"
                                    class="btn btn-tool"
                                    data-card-widget="collapse"
                                    >
                                    <i class="fas fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="chart">
                                <canvas id="revenueQuarter"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script>
//    let data1 = [];
//    let labels1 = [];
    let data2 = [];
    let label2 = [];
//    let colors=[];
//    let borderColors=[];
//    let r, g, b;
  <%--<c:forEach items="${revenueMonth}" var="r">--%>
//    data1.push(${r[1]});
//    labels1.push(${r[0]});

//        r = Math.random()*255;
//        g = Math.random()*255;
//        b = Math.random()*255;
//
//        colors.push(`rgba(${r}, ${g}, ${b}, 0.2)`);
//        borderColors.push(`rgba(${r}, ${g}, ${b}, 1)`);
    <%--</c:forEach>--%>
    <c:forEach items="${revenueQuarter}" var="r">
    data2.push(${r[1]});
    label2.push('${r[0]}');

//        r = Math.random()*255;
//        g = Math.random()*255;
//        b = Math.random()*255;
//
//        colors.push(`rgba(${r}, ${g}, ${b}, 0.2)`);
//        borderColors.push(`rgba(${r}, ${g}, ${b}, 1)`);
    </c:forEach>

    window.onload = function () {
        drawChart(data2,label2, "revenueQuarter","Doanh Thu" );
//        let ctx1 = document.getElementById("revenueMonthStat").getContext("2d");
//        drawChart(ctx1, data1, labels1, "Danh thu theo từng tháng trong năm", "line");
//
//        let ctx2 = document.getElementById("revenueQuarter").getContext("2d");
//        drawChart(ctx2, data2, labels2, "Danh thu các quý trong năm", "line");
    };
</script>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>