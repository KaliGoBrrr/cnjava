<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách khách hàng</title>
    <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Additional CSS to align icons with content */
        table i {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <h1>Danh sách khách hàng</h1>
    
    <%@ page import="java.sql.*" %>
    <%@ page import="Servlets.*" %>
    
    <% 
        Connection conn = null;
        try {
            conn = MySQLConntUtils.getMySQLConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM KhachHang");
    %>
    
    <div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="KhachHangnew.jsp">Thêm khách hàng</a></button>
    </div>
    
    <!-- Search section -->
    <form method="GET" action="KhachHangfind">
        <label for="searchKeyword">Tìm kiếm khách hàng:</label>
        <input type="text" id="searchKeyword" name="keyword">
        <input type="submit" value="Tìm kiếm">
    </form>
    
    <table border="1" class="fixed-width-table">
        <tr>
            <th>Mã khách hàng</th>
            <th>Tên khách hàng</th>
            <th>Địa chỉ</th>
            <th>Điện thoại</th>
            <th>Email</th>
            <th>Xóa</th>
            <th>Sửa</th>
        </tr>
        <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("ma_khach_hang") %></td>
            <td><%= rs.getString("ten_khach_hang") %></td>
            <td><%= rs.getString("dia_chi") %></td>
            <td><%= rs.getString("dien_thoai") %></td>
            <td><%= rs.getString("email") %></td>
            <td>
                <form method="POST" action="KhachHangxoa">
                    <input type="hidden" name="ma_khach_hang" value="<%= rs.getString("ma_khach_hang") %>">
                    <button type="submit" class="icon-button"><i class="fas fa-trash-alt"></i></button>
                </form>
            </td>
            <td>
                <a href="KhachHangfix.jsp?ma_khach_hang=<%= rs.getString("ma_khach_hang") %>" class="icon-link"><i class="fas fa-edit"></i></a>
            </td>
        </tr>
        <% } %>
    </table>
    
    <% 
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    } %>
</body>
</html>
