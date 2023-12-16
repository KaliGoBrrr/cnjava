<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <h1>Danh sách sản phẩm</h1>
    
    <%-- Kết nối với cơ sở dữ liệu để lấy thông tin sản phẩm --%>
    <%@ page import="java.sql.*" %>
    <%@ page import="Servlets.*" %>
    <% Connection conn = null;
       try {
           conn = MySQLConntUtils.getMySQLConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM SanPham");
    %>
	<div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="SanPhamnew.jsp">Thêm sản phẩm</a></button>
    </div>
    <!-- Trong phần hiển thị danh sách -->
    <form method="GET" action="SanPhamfind">
    <label for="searchKeyword">Tìm kiếm sản phẩm:</label>
    <input type="text" id="searchKeyword" name="keyword">
    <input type="submit" value="Tìm kiếm">
	</form>
    
<table border="1" class="fixed-width-table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng trong kho</th>
        <th>Nhà sản xuất</th>
        <th>Mã danh mục</th>
        <th>Xóa</th>
        <th>Sửa</th>
    </tr>
    <% while (rs.next()) { %>
    <tr>
        <td><%= rs.getString("ma_san_pham") %></td>
        <td><%= rs.getString("ten_san_pham") %></td>
        <td><%= rs.getDouble("gia") %></td>
        <td><%= rs.getInt("so_luong_trong_kho") %></td>
        <td><%= rs.getString("nha_san_xuat") %></td>
        <td><%= rs.getString("ma_danh_muc") %></td>
        <td>
                <form method="POST" action="SanPhamxoa">
                    <input type="hidden" name="ma_san_pham" value="<%= rs.getString("ma_san_pham") %>">
                    <button type="submit" class="icon-button"><i class="fas fa-trash-alt"></i></button>
                </form>
            </td>
            <td>
                <a href="SanPhamfix.jsp?ma_san_pham=<%= rs.getString("ma_san_pham") %>" class="icon-link"><i class="fas fa-edit"></i></a>
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
