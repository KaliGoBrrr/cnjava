<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm danh mục</title>
       <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">

</head>
<body>
    <h1>Kết quả tìm kiếm danh mục</h1>
    
    <!-- Hiển thị danh sách danh mục -->
    <table border="1">
        <tr>
            <th>Mã danh mục</th>
            <th>Tên danh mục</th>
            <!-- Các cột khác nếu cần -->
        </tr>
        
        <!-- Sử dụng forEach để hiển thị danh sách danh mục tìm được -->
        <c:forEach items="${danhMucList}" var="danhMuc">
            <tr>
                <td>${danhMuc.ma_danh_muc}</td>
                <td>${danhMuc.ten_danh_muc}</td>
                <!-- Các cột khác nếu cần -->
            </tr>
        </c:forEach>
        <div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="DanhMuc.jsp">Về danh mục</a></button>
    	</div>
    </table>
</body>
</html>
