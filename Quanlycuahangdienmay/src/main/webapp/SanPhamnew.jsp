<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thêm sản phẩm</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>

<body>

    <h1>Thêm sản phẩm</h1>

    <form method="POST" action="SanPhamServlet">

        <table>

            <tr>
                <td>Mã sản phẩm</td>
                <td><input type="text" name="ma_san_pham" /></td>
            </tr>

            <tr>
                <td>Tên sản phẩm</td>
                <td><input type="text" name="ten_san_pham" /></td>
            </tr>

            <tr>
                <td>Giá</td>
                <td><input type="double" name="gia" /></td>
            </tr>

            <tr>
                <td>Số lượng trong kho</td>
                <td><input type="int" name="so_luong_trong_kho" /></td>
            </tr>

            <tr>
                <td>Nhà sản xuất</td>
                <td><input type="text" name="nha_san_xuat" /></td>
            </tr>

            <tr>
                <td>Mã danh mục</td>
                <td><input type="text" name="ma_danh_muc" /></td>
            </tr>

            <tr>
                <td colspan="2">
                    <button>Thêm</button>
                    <button><a href="SanPham.jsp">Sản phẩm</a></button>
                </td>
            </tr>

        </table>

    </form>

</body>

</html>
