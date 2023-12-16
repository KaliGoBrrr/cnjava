<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách đơn hàng</title>
    <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <h1>Danh sách đơn hàng</h1>
    
    <%@ page import="java.sql.*" %>
    <%@ page import="Servlets.*" %>
    <% Connection conn = null;
       try {
           conn = MySQLConntUtils.getMySQLConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM DonHang");
    %>
	<div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="DonHangnew.jsp">Thêm đơn hàng</a></button>
    </div>
    <form method="GET" action="DonHangfind">
        <label for="searchKeyword">Tìm kiếm đơn hàng:</label>
        <input type="text" id="searchKeyword" name="keyword">
        <input type="submit" value="Tìm kiếm">
	</form>
    
    <table border="1" class="fixed-width-table">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Mã khách hàng</th>
            <th>Mã sản phẩm</th>
            <th>Ngày mua hàng</th>
            <th>Xóa</th>
            <th>Sửa</th>
        </tr>
        <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("ma_don_hang") %></td>
            <td><%= rs.getString("ma_khach_hang") %></td>
            <td><%= rs.getString("ma_san_pham") %></td>
            <td><%= rs.getString("ngay_mua_hang") %></td>
            <td>
                <form method="POST" action="DonHangxoa">
                    <input type="hidden" name="ma_don_hang" value="<%= rs.getString("ma_don_hang") %>">
                    <button type="submit" class="icon-button"><i class="fas fa-trash-alt"></i></button>
                </form>
            </td>
            <td>
                <a href="DonHangfix.jsp?ma_don_hang=<%= rs.getString("ma_don_hang") %>" class="icon-link"><i class="fas fa-edit"></i></a>
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
