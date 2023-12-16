<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa chi tiết đơn hàng</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>
<body>
    <h1>Sửa chi tiết đơn hàng</h1>

    <%-- Lấy thông tin danh mục từ request để hiển thị --%>
    <%@ page import="Servlets.*" %>
    <%@ page import="java.sql.*" %>
    <% String ma_chi_tiet_don_hang = request.getParameter("ma_chi_tiet_don_hang");
       Chitietdonhang chiTietDonHang = null;
       try {
           Connection conn = MySQLConntUtils.getMySQLConnection();
           chiTietDonHang = DBUtils.findChi(conn, ma_chi_tiet_don_hang);
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Hiển thị form để chỉnh sửa thông tin danh mục --%>
    <form method="post" action="ChiTietDonHangfix">
        <input type="hidden" name="ma_chi_tiet_don_hang" value="<%= chiTietDonHang.getMa_chi_tiet_don_hang() %>">
        <label for="ma_don_hang">Mã đơn hàng:</label>
        <input type="text" id="ma_don_hang" name="ma_don_hang" value="<%= chiTietDonHang.getMa_don_hang() %>"><br><br>
        <label for="ma_san_pham">Mã sản phẩm:</label>
        <input type="text" id="ma_san_pham" name="ma_san_pham" value="<%= chiTietDonHang.getMa_san_pham() %>"><br><br>
        <label for="so_luong">Số lượng:</label>
        <input type="int" id="so_luong" name="so_luong" value="<%= chiTietDonHang.getSo_luong() %>"><br><br>
        <label for="don_gia">Đơn giá:</label>
        <input type="double" id="don_gia" name="don_gia" value="<%= chiTietDonHang.getDon_gia() %>"><br><br>
        <label for="tong_tien">Tổng tiền:</label>
        <input type="double" id="tong_tien" name="tong_tien" value="<%= chiTietDonHang.getTong_tien() %>"><br><br>
        <input type="submit" value="Lưu">
    </form>
</body>
</html>
