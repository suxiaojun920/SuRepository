<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
	</head>
	<body>
		<form action="loginHandler" method="post">
			用户名:<input type="text" name="userName"/><br/>
			密码:<input type="password" name="userPwd"/><br/>
			<input type="submit" value="提交"/>
			<input type="reset" value="取消"/>
		</form>
	</body>
</html>
