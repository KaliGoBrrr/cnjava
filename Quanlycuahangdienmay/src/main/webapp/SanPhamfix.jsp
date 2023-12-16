<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>
<body>
    <h1>Sửa Sản Phẩm</h1>

    <%-- Lấy thông tin danh mục từ request để hiển thị --%>
    <%@ page import="Servlets.*" %>
    <%@ page import="java.sql.*" %>
    <% String ma_san_pham = request.getParameter("ma_san_pham");
       Sanpham sanPham = null;
       try {
           Connection conn = MySQLConntUtils.getMySQLConnection();
           sanPham = DBUtils.findSan(conn, ma_san_pham);
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    %>

    <%-- Hiển thị form để chỉnh sửa thông tin danh mục --%>
    <form method="post" action="SanPhamfix">
        <input type="hidden" name="ma_san_pham" value="<%= sanPham.getMa_san_pham() %>">
        <label for="ten_san_pham">Tên sản phẩm:</label>
        <input type="text" id="ten_san_pham" name="ten_san_pham" value="<%= sanPham.getTen_san_pham() %>"><br><br>
        <label for="gia">Giá:</label>
        <input type="text" id="gia" name="gia" value="<%= sanPham.getGia() %>"><br><br>
        <label for="so_luong_trong_kho">Số lượng trong kho:</label>
        <input type="text" id="so_luong_trong_kho" name="so_luong_trong_kho" value="<%= sanPham.getSo_luong_trong_kho() %>"><br><br>
        <label for="nha_san_xuat">Nhà sản xuất:</label>
        <input type="text" id="nha_san_xuat" name="nha_san_xuat" value="<%= sanPham.getNha_san_xuat() %>"><br><br>
        <label for="ma_danh_muc">Mã danh mục:</label>
        <input type="text" id="ma_danh_muc" name="ma_danh_muc" value="<%= sanPham.getMa_danh_muc() %>"><br><br>
        <input type="submit" value="Lưu">
    </form>
</body>
</html>
