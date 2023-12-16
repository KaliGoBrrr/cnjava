<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Thêm Đơn Hàng</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>

<body>

    <h1>Thêm Đơn Hàng</h1>

    <form method="POST" action="DonHangServlet">

        <table>

            <tr>
                <td>Mã đơn hàng</td>
                <td><input type="text" name="ma_don_hang" /></td>
            </tr>

            <tr>
                <td>Mã khách hàng</td>
                <td><input type="text" name="ma_khach_hang" /></td>
            </tr>

            <tr>
                <td>Mã sản phẩm</td>
                <td><input type="text" name="ma_san_pham" /></td>
            </tr>

            <tr>
                <td>Ngày mua hàng</td>
                <td><input type="date" name="ngay_mua_hang" /></td>
            </tr>

            <!-- Thêm các trường thông tin cần thiết khác -->

            <tr>
                <td colspan="2">
                    <button>Thêm</button>
                    <button><a href="DonHang.jsp">Đơn hàng</a></button>
                </td>
            </tr>

        </table>

    </form>

</body>

</html>
