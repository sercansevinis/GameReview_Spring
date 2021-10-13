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
<title><spring:message code="aboutPub" /></title>
</head>
<body>
	<h2><spring:message code="publisher" />&nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a></h2>
	<table>
		<tr>
			<td rowspan="4"><img src="/img/publishers/${publisher.id}.jpg" height="200px" width="200px"></td>		
			<td><b><spring:message code="pname" /> </b>${publisher.name}</td>
		</tr>
		<tr>
			<td><b><spring:message code="loc" /> </b>${publisher.location}</td>
		</tr>	
		<tr>	
			<td><b><spring:message code="avgscore" /> </b>${publisher.avgscore}</td>
		</tr>
		<tr>	
			<td><b>Url: </b>${publisher.url}</td>
		</tr>		
	</table>
<h2>-------------------------------------------------------------------------------------------------</h2>	
	<table>
		<tr>	
			<td><b><spring:message code="gof" /> ${publisher.name}:</b>
			<c:forEach items="${games}" var="g">
				<li><a href="/game/${g.id}">${g.name}</a></li>
			</c:forEach>
		</td>
		</tr>
	</table>	
	<p><a href="?language=tr"><img src="/img/tr.png" height="20" width="20"></a> | <a href="?language=en"><img src="/img/en.png" height="20" width="20"></a></p>
</body>
</html>