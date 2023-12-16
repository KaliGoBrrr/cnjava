<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm khách hàng</title>
       <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">

</head>
<body>
    <h1>Kết quả tìm kiếm khách hàng</h1>
    
    <table border="1">
        <tr>
            <th>Mã khách hàng</th>
            <th>Tên khách hàng</th>
            <th>Địa chỉ</th>
            <th>Điện thoại</th>
            <th>Email</th>
            <!-- Các cột khác nếu cần -->
        </tr>
        
        <c:forEach items="${khachHanglist}" var="khachHang">
            <tr>
                <td>${khachHang.ma_khach_hang}</td>
                <td>${khachHang.ten_khach_hang}</td>
                <td>${khachHang.dia_chi}</td>
                <td>${khachHang.dien_thoai}</td>
                <td>${khachHang.email}</td>
            </tr>
        </c:forEach>
        <div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="KhachHang.jsp">Về khách hàng</a></button>
    	</div>
    </table>
</body>
</html>
