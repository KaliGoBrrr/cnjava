<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Thêm danh mục</title>

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

<td colspan="2"><button>Submit</button><button><a href="DanhMuc.jsp">Danhmuc</a></button></td>

</tr>

</table>

</form>

</body>

</html>