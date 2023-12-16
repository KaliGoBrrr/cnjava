<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đơn hàng</title>
	<link rel="stylesheet" type="text/css" href="css/giaodienbang.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	
</head>
<body>
    <h1>Chi tiết đơn hàng</h1>
    
    <%-- Kết nối với cơ sở dữ liệu để lấy thông tin chi tiết đơn hàng --%>
    <%@ page import="java.sql.*" %>
    <%@ page import="Servlets.*" %>
    <% Connection conn = null;
       try {
           conn = MySQLConntUtils.getMySQLConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM ChiTietDonHang");
    %>
	<div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="ChiTietDonHangnew.jsp">Thêm chi tiết đơn hàng</a></button>
    </div>
    <!-- Trong phần hiển thị danh sách -->
    <form method="GET" action="ChiTietDonHangfind">
    <label for="searchKeyword">Tìm kiếm chi tiết đơn hàng:</label>
    <input type="text" id="searchKeyword" name="keyword">
    <input type="submit" value="Tìm kiếm">
	</form>
    
<table border="1" class="fixed-width-table">
    <tr>
        <th>Mã chi tiết đơn hàng</th>
        <th>Mã đơn hàng</th>
        <th>Mã sản phẩm</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Tổng tiền</th>
        <!-- Thêm các cột khác cần hiển thị -->
        <!-- ... -->
        <th>Xóa</th>
        <th>Sửa</th>
    </tr>
    <% while (rs.next()) { %>
    <tr>
        <td><%= rs.getString("ma_chi_tiet_don_hang") %></td>
        <td><%= rs.getString("ma_don_hang") %></td>
        <td><%= rs.getString("ma_san_pham") %></td>
        <td><%= rs.getInt("so_luong") %></td>
        <td><%= rs.getDouble("don_gia") %></td>
        <td><%= rs.getDouble("tong_tien") %></td>
        <!-- Hiển thị các thông tin khác của chi tiết đơn hàng -->
        <!-- ... -->
        <td>
    	<form method="POST" action="ChiTietDonHangxoa">
        <input type="hidden" name="ma_chi_tiet_don_hang" value="<%= rs.getString("ma_chi_tiet_don_hang") %>">
        <button type="submit" class="icon-button"><i class="fas fa-trash-alt"></i></button>
   	 	</form>
		</td>
		<td>
    	<a href="ChiTietDonHangfix.jsp?ma_chi_tiet_don_hang=<%= rs.getString("ma_chi_tiet_don_hang") %>" class="icon-link"><i class="fas fa-edit"></i></a>
		</td>

    </tr>
    <% } %>
</table>

    <% rs.close();
       stmt.close();
       conn.close();
    } catch (Exception e) {
       e.printStackTrace();
    } %>
</body>
</html>
