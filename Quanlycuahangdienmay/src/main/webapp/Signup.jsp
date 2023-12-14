<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <link rel="stylesheet" type="text/css" href="css/DKvaDN.css">
</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Sign In</title>

</head>

<body>

<h1>Sign In</h1>

<form method="POST" action="SignupServlet">

<table>

<tr>

<td>UserName</td>

<td><input type="text" name="Username"/>

</tr>

<tr>

<td>Gender</td>
<td><input type="text" name="Gender"/></td> 

</tr>

<tr>

<td>PassWord</td>

<td><input type="password" name="PassWord"/></td>

</tr>

<tr>

<td colspan="2"><button>Submit</button><button><a href="index.jsp">Login</a></button></td>

</tr>

</table>

</form>

</body>

</html>