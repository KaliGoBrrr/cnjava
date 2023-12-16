<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thêm chi tiết đơn hàng</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>

<body>

    <h1>Thêm chi tiết đơn hàng</h1>

    <form method="POST" action="ChiTietDonHangServlet">

        <table>

            <tr>
                <td>Mã chi tiết đơn hàng</td>
                <td><input type="text" name="ma_chi_tiet_don_hang" /></td>
            </tr>

            <tr>
                <td>Mã đơn hàng</td>
                <td><input type="text" name="ma_don_hang" /></td>
            </tr>

            <tr>
                <td>Mã sản phẩm</td>
                <td><input type="text" name="ma_san_pham" /></td>
            </tr>

            <tr>
                <td>Số lượng</td>
                <td><input type="int" name="so_luong" /></td>
            </tr>

            <tr>
                <td>Đơn giá</td>
                <td><input type="double" name="don_gia" /></td>
            </tr>

            <tr>
                <td colspan="2">
                    <button>Thêm</button>
                    <button><a href="ChiTietDonHang.jsp">Sản phẩm</a></button>
                </td>
            </tr>

        </table>

    </form>

</body>

</html>
