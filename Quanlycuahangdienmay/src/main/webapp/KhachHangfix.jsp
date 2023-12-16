<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Khách Hàng</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>
<body>
    <h1>Sửa Khách Hàng</h1>

    <%-- Lấy thông tin khách hàng từ request để hiển thị --%>
    <%@ page import="Servlets.*" %>
    <%@ page import="java.sql.*" %>
    <% String ma_khach_hang = request.getParameter("ma_khach_hang");
       Khachhang khachHang = null;
       try {
           Connection conn = MySQLConntUtils.getMySQLConnection();
           khachHang = DBUtils.findKhach(conn, ma_khach_hang);
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Hiển thị form để chỉnh sửa thông tin khách hàng --%>
    <form method="post" action="KhachHangfix">
        <input type="hidden" name="ma_khach_hang" value="<%= khachHang.getMa_khach_hang() %>">
        <label for="ten_khach_hang">Tên khách hàng:</label>
        <input type="text" id="ten_khach_hang" name="ten_khach_hang" value="<%= khachHang.getTen_khach_hang() %>"><br><br>
        <label for="dia_chi">Địa chỉ:</label>
        <input type="text" id="dia_chi" name="dia_chi" value="<%= khachHang.getDia_chi() %>"><br><br>
        <label for="dien_thoai">Điện thoại:</label>
        <input type="text" id="dien_thoai" name="dien_thoai" value="<%= khachHang.getDien_thoai() %>"><br><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="<%= khachHang.getEmail() %>"><br><br>
        <input type="submit" value="Lưu">
    </form>
</body>
</html>
