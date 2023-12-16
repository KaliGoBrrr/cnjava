<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm chi tiết hóa đơn</title>
       <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">
</head>
<body>
    <h1>Kết quả tìm kiếm chi tiết hóa đơn</h1>
    
    <table border="1">
        <tr>
            <th>Mã chi tiết đơn hàng</th>
            <th>Mã đơn hàng</th>
			<th>Mã sản phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Tổng tiền</th>
        </tr>
        
        <c:forEach items="${chiTietDonHanglist}" var="chiTietDonHang">
            <tr>
                <td>${chiTietDonHang.ma_chi_tiet_don_hang}</td>
                <td>${chiTietDonHang.ma_don_hang}</td>
                <td>${chiTietDonHang.ma_san_pham}</td>
                <td>${chiTietDonHang.so_luong}</td>
                <td>${chiTietDonHang.don_gia}</td>
                <td>${chiTietDonHang.tong_tien}</td>
            </tr>
        </c:forEach>
        <div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="ChiTietDonHang.jsp">Về sản phẩm</a></button>
    	</div>
    </table>
</body>
</html>
