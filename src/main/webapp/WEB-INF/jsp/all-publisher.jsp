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
<title><spring:message code="allPub" /></title>
</head>
<body>
	<h2><spring:message code="allPub" />&nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a></h2>
	<p><spring:message code="listPub" /></p>
	<c:choose>
		<c:when test="${fn:length(publishers) > 0}">	
			<table>
				<tr>
					<th><spring:message code="pname" /></th>
				</tr>
				<c:forEach items="${publishers}" var="p">
					<tr>
						<td><a href="/game/${p.id}/">${p.name}</a></td>
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