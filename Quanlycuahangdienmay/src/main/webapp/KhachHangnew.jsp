<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Thêm Khách Hàng</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
</head>

<body>

    <h1>Thêm Khách Hàng</h1>

    <form method="POST" action="KhachHangServlet">

        <table>

            <tr>
                <td>Mã khách hàng</td>
                <td><input type="text" name="ma_khach_hang" /></td>
            </tr>

            <tr>
                <td>Tên khách hàng</td>
                <td><input type="text" name="ten_khach_hang" /></td>
            </tr>

            <tr>
                <td>Địa chỉ</td>
                <td><input type="text" name="dia_chi" /></td>
            </tr>

            <tr>
                <td>Điện thoại</td>
                <td><input type="text" name="dien_thoai" /></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" /></td>
            </tr>

            <tr>
                <td colspan="2">
                    <button>Thêm</button>
                    <button><a href="KhachHang.jsp">Khách hàng</a></button>
                </td>
            </tr>

        </table>

    </form>

</body>

</html>
