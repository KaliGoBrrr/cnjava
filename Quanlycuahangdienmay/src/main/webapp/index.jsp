<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" type="text/css" href="css/DKvaDN.css">
</head>

<body>

<h1>Login</h1>

<form method="POST" action="LoginServlet">

<table>

<tr>

<td>UserName</td>

<td><input type="text" name="Username"/>

</tr>

<tr>

<td>PassWord</td>

<td><input type="password" name="PassWord"/></td>

</tr>

<tr>

<td colspan="2"><button>Login</button><button><a href="Signup.jsp">Signup</a></button></td>

</tr>

</table>

</form>

</body>

</html>