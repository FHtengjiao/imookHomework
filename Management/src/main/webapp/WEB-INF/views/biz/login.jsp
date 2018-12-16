<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" href="../../../css/login.css">
    </head>
    <body>
        <div class="login">
            <div class="header">
                <h1>
                    <a href="${pageContext.request.contextPath}/toLogin.do">登录</a>
                </h1>
                <button></button>
            </div>
            <form action="${pageContext.request.contextPath}/login.do" method="post">
                <div class="name">
                    <input type="text" id="name" name="account">
                    <p></p>
                </div>
                <div class="pwd">
                    <input type="password" id="pwd" name="password">
                    <p></p>
                </div>
                <div class="btn-red">
                    <input type="submit" value="登录" id="login-btn">
                </div>
            </form>
        </div>
    </body>
</html>