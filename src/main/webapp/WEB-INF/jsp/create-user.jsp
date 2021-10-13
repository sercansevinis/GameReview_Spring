<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>Create a new user</title>
</head>
<body>
	<h2>
		Create New User&nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a>
	</h2>
	<form:form method="post" action="/create/user" modelAttribute="user">
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan=3><input type=submit value="Send"></td>
			</tr>
		</table>
	</form:form>
<body>
</html>