<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
    <style>
        /* CSS để trang trí */
        /* ... */
    </style>
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

    <table border="1">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng trong kho</th>
            <th>Nhà sản xuất</th>
            <th>Mã danh mục</th>
        </tr>
        <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("ma_san_pham") %></td>
            <td><%= rs.getString("ten_san_pham") %></td>
            <td><%= rs.getString("gia") %></td>
            <td><%= rs.getString("so_luong_trong_kho") %></td>
            <td><%= rs.getString("nha_san_xuat") %></td>
            <td><%= rs.getString("ma_danh_muc") %></td>
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
