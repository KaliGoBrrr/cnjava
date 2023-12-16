<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Đơn Hàng</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>
<body>
    <h1>Sửa Đơn Hàng</h1>

    <%-- Lấy thông tin danh mục từ request để hiển thị --%>
    <%@ page import="Servlets.*" %>
    <%@ page import="java.sql.*" %>
    <% String ma_don_hang = request.getParameter("ma_don_hang");
       Donhang donHang = null;
       try {
           Connection conn = MySQLConntUtils.getMySQLConnection();
           donHang = DBUtils.findDon(conn, ma_don_hang);
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Hiển thị form để chỉnh sửa thông tin danh mục --%>
    <form method="post" action="DonHangfix">
        <input type="hidden" name="ma_don_hang" value="<%= donHang.getMa_don_hang() %>">
        <label for="ma_khach_hang">Mã khách hàng:</label>
        <input type="text" id="ma_khach_hang" name="ma_khach_hang" value="<%= donHang.getMa_khach_hang() %>"><br><br>
        <label for="ma_san_pham">Mã sản phẩm:</label>
        <input type="text" id="ma_san_pham" name="ma_san_pham" value="<%= donHang.getMa_san_pham() %>"><br><br>
        <label for="ngay_mua_hang">Ngày mua hàng:</label>
        <input type="date" id="ngay_mua_hang" name="ngay_mua_hang" value="<%= donHang.getNgay_mua_hang() %>"><br><br>
        <input type="submit" value="Lưu">
    </form>
</body>
</html>
