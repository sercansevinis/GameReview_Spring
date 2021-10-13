<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title><spring:message code="aboutGenre" /></title>
</head>
<body>
	<h2><spring:message code="genre" />&nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a></h2>
	<table class="bordered">
		<tr>
			<td><spring:message code="genreName" /> </td>
			<td>${genre.name}</td>
		</tr>
		<tr>
			<td><spring:message code="rgames" /></td>
			<td>
				<c:forEach items="${game}" var="g">
					<li><a href="/game/${g.id}/">${g.name} </a>  --->  <a href="/publisher/${g.publisher.id}">${g.publisher.name}</a></li>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><a><spring:message code="tgame" /> ${fn:length(game)}</a></td>
		</tr>
	</table>
	<p><a href="?language=tr"><img src="/img/tr.png" height="20" width="20"></a> | <a href="?language=en"><img src="/img/en.png" height="20" width="20"></a></p>
</body>
</html>