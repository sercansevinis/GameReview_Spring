
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="ISO-8859-1">
<title><spring:message code="allGames" /></title>
</head>
<body>
	<h2><spring:message code="allGames" />&nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a></h2>
	<p><spring:message code="listGame" /></p>
	<c:choose>
		<c:when test="${fn:length(games) > 0}">	
			<table>
				<tr>
					<th><spring:message code="name" /></th>
					<th><spring:message code="gscore" /></th>
				</tr>
				<c:forEach items="${games}" var="g">
					<tr>
						<td><a href="/game/${g.id}/">${g.name}</a></td>
						<td>${g.reviewRate}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>No data found.</p>
		</c:otherwise>
	</c:choose>
	<p><a href="?language=tr"><img src="/img/tr.png" height="20" width="20"></a> | <a href="?language=en"><img src="/img/en.png" height="20" width="20"></a></p>
</body>
</html>