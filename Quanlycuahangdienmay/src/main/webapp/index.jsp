<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" type="text/css" href="css/loginandsignup.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h1>Login</h1>
            <form method="POST" action="LoginServlet">
                <div class="form-group">
                    <label for="username">UserName</label>
                    <input type="text" id="username" name="Username"/>
                </div>
                <div class="form-group">
                    <label for="password">PassWord</label>
                    <input type="password" id="password" name="PassWord"/>
                </div>
                <div class="form-group">
                    <button type="submit">Login</button>
                    <a href="Signup.jsp">Signup</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>