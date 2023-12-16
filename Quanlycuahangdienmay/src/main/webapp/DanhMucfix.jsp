<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Danh Mục</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>
<body>
    <h1>Sửa Danh Mục</h1>

    <%-- Lấy thông tin danh mục từ request để hiển thị --%>
    <%@ page import="Servlets.*" %>
    <%@ page import="java.sql.*" %>
    <% String ma_danh_muc = request.getParameter("ma_danh_muc");
       Danhmuc danhMuc = null;
       try {
           Connection conn = MySQLConntUtils.getMySQLConnection();
           danhMuc = DBUtils.findDanh(conn, ma_danh_muc);
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Hiển thị form để chỉnh sửa thông tin danh mục --%>
    <form method="post" action="DanhMucfix">
        <input type="hidden" name="ma_danh_muc" value="<%= danhMuc.getMa_danh_muc() %>">
        <label for="ten_danh_muc">Tên danh mục:</label>
        <input type="text" id="ten_danh_muc" name="ten_danh_muc" value="<%= danhMuc.getTen_danh_muc() %>"><br><br>
        <input type="submit" value="Lưu">
    </form>
</body>
</html>
