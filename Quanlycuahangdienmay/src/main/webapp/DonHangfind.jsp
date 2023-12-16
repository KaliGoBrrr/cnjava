<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm đơn hàng</title>
       <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">

</head>
<body>
    <h1>Kết quả tìm kiếm đơn hàng</h1>
    
    <table border="1">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Mã khách hàng</th>
            <th>Mã sản phẩm</th>
            <th>Ngày mua hàng</th>
            <!-- Các cột khác nếu cần -->
        </tr>
        
        <c:forEach items="${donHanglist}" var="donHang">
            <tr>
                <td>${donHang.ma_don_hang}</td>
                <td>${donHang.ma_khach_hang}</td>
                <td>${donHang.ma_san_pham}</td>
                <td>${donHang.ngay_mua_hang}</td>
                <!-- Các cột khác nếu cần -->
            </tr>
        </c:forEach>
        <div class="menu">
            <button><a href="Trangchu.jsp">Trang Chủ</a></button>
            <button><a href="DonHang.jsp">Về đơn hàng</a></button>
        </div>
    </table>
</body>
</html>
