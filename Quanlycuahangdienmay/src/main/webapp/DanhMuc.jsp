<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách danh mục</title>
    <link rel="stylesheet" type="text/css" href="css/giaodienbang.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    <h1>Danh sách danh mục</h1>
    
    <%-- Kết nối với cơ sở dữ liệu để lấy thông tin sản phẩm --%>
    <%@ page import="java.sql.*" %>
    <%@ page import="Servlets.*" %>
    <% Connection conn = null;
       try {
           conn = MySQLConntUtils.getMySQLConnection();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM DanhMuc");
    %>
    <div class="menu">
        <button><a href="Trangchu.jsp">Trang Chủ</a></button>
        <button><a href="DanhMucnew.jsp">Thêm danh mục</a></button>
    </div>
    <!-- Trong phần hiển thị danh sách -->
    <form method="GET" action="DanhMucfind">
    <label for="searchKeyword">Tìm kiếm danh mục:</label>
    <input type="text" id="searchKeyword" name="keyword">
    <input type="submit" value="Tìm kiếm">
    </form>
    
    <table border="1" class="fixed-width-table">
        <tr>
            <th>Mã danh mục</th>
            <th>Tên danh mục</th>
            <th>Xóa</th>
            <th>Sửa</th>
        </tr>
        <% while (rs.next()) { %>
        <tr>
            <td><%= rs.getString("ma_danh_muc") %></td>
            <td><%= rs.getString("ten_danh_muc") %></td>
            <td>
                <form method="POST" action="DanhMucxoa">
                    <input type="hidden" name="ma_danh_muc" value="<%= rs.getString("ma_danh_muc") %>">
                    <button type="submit" class="icon-button"><i class="fas fa-trash-alt"></i></button>
                </form>
            </td>
            <td>
                <a href="DanhMucfix.jsp?ma_danh_muc=<%= rs.getString("ma_danh_muc") %>" class="icon-link"><i class="fas fa-edit"></i></a>
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
