<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm sản phẩm</title>
       <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">

</head>
<body>
    <h1>Kết quả tìm kiếm sản phẩm</h1>
    
    <table border="1">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
			<th>Giá</th>
            <th>Số lượng trong kho</th>
            <th>Nhà sản xuất</th>
            <th>Mã danh mục</th>
        </tr>
        
        <c:forEach items="${sanPhamlist}" var="sanPham">
            <tr>
                <td>${sanPham.ma_san_pham}</td>
                <td>${sanPham.ten_san_pham}</td>
                <td>${sanPham.gia}</td>
                <td>${sanPham.so_luong_trong_kho}</td>
                <td>${sanPham.nha_san_xuat}</td>
                <td>${sanPham.ma_danh_muc}</td>
            </tr>
        </c:forEach>
        <div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="SanPham.jsp">Về sản phẩm</a></button>
    	</div>
    </table>
</body>
</html>
