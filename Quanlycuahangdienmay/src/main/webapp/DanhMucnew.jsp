<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Thêm danh mục</title>
<link rel="stylesheet" type="text/css" href="css/new.css">
</head>

<body>

<h1>Thêm danh mục</h1>

<form method="POST" action="DanhMucServlet">

<table>

<tr>

<td>Mã danh mục</td>

<td><input type="text" name="ma_danh_muc"/>

</tr>

<tr>

<td>Tên danh mục</td>
<td><input type="text" name="ten_danh_muc"/></td> 

</tr>

<tr>
                <td colspan="2">
                    <button>Thêm</button>
                    <button><a href="DanhMuc.jsp">Danh mục</a></button>
                </td>
            </tr>

</table>

</form>

</body>

</html>