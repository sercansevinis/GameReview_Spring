<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>
		User Login&nbsp;<a href="/menu"><img src="/img/home.png"height="20" width="20"></a>
	</h2>
	<p>Please enter your username and password</p>
	<form:form method="post" action="/login" modelAttribute="user">
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan=2><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="Login" /></td>
				<td><a href="/display-admin-form">Admin Login</a></td>
				<td><a href="/create-user">New user</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>