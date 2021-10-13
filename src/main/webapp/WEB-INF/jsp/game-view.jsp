<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title><spring:message code="aboutGame" /></title>
</head>
<body>
	<h2><spring:message code="game" />  &nbsp;<a href="/game/update/${game.id}"><img src="/img/update.png" height="20" width="20"></a>	
	 &nbsp;<a href="/game/delete/${game.id}"><img src="/img/delete.png" height="20" width="20"></a>
	 &nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a>
	</h2>
	<table>
		<tr>
			<td rowspan="6"><img src="/img/games/${game.id}.jpg" height="240px" width="180px"></td>		
			<td><b><spring:message code="gameName" /> </b>${game.name}</td>
		</tr>
		<tr>
			<td><b><spring:message code="rRate" />  </b>${game.reviewRate}</td>
		</tr>	
		<javatime:format value="${game.rdate}" pattern="dd-MM-yyy" var="formattedDate"/>
		<tr>	
			<td><b><spring:message code="rDate" />  </b>${formattedDate}</td>
		</tr>
		<tr>	
			<td><b><spring:message code="platforms" />  </b>${game.platforms}</td>
		</tr>	
		<tr>	
			<td><b><spring:message code="pname" />  </b><a href="/publisher/${game.publisher.id}/">${publisher.name}</a></td>
		</tr>	
		<tr>	
			<td><b><spring:message code="genres" />  </b>
			<c:forEach items="${genres}" var="g">
				<li><a href="/genre/${g.id}/">${g.name}</a></li>
			</c:forEach>
		</td>
		</tr>
	</table>
	<p><a href="?language=tr"><img src="/img/tr.png" height="20" width="20"></a> | <a href="?language=en"><img src="/img/en.png" height="20" width="20"></a></p>
</body>
</html>