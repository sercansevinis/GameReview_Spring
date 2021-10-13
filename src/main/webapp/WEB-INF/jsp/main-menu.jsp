<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title><spring:message code="mm" /></title>
</head>
<body>
	<p>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/list-games">List of All Games</a> | <a href="/list-publishers">List of All Publishers</a> | <a href="/list-genres">List of All Genres</a>
	</p>
	<form:form method="post" action="/searchedItem" modelAttribute="searchEngine">
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form:select path="type">
				<form:option value="" label="-- Please Select --" />
				<form:option value="Game" label="Games" />
				<form:option value="Genre" label="Genre" />
				<form:option value="Publisher" label="Publisher" />
			</form:select>
			<form:input path="searchedItem" />
			<input type="submit" value="Search">
		</div>
	</form:form>
	<table>
		<tr>
			<td>
				<h3>
					&nbsp;&nbsp;&nbsp;<spring:message code="t5g" />&nbsp;<a href="/add-game/"><img src="/img/add.png" height="30" width="30"></a>
				</h3>
				<h1>--------------------------</h1>
			</td>
			<td>
				<h3>
					&nbsp;&nbsp;&nbsp;<spring:message code="t5p" />&nbsp;	
				</h3>
				<h1>--------------------------</h1>
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td>
				<table>
					<c:choose>
						<c:when test="${fn:length(topFive) > 0}">
							<ul>
								<c:forEach items="${topFive}" var="t">
									<li><a href="/game/${t.id}">${t.name}</a> - ${t.reviewRate}</li>
								</c:forEach>
							</ul>
						</c:when>
						<c:otherwise>
							<p class="small-italic">No Games available.</p>
						</c:otherwise>
					</c:choose>
				</table>
			</td>
			
			<td>
				<table>
					<c:choose>
						<c:when test="${fn:length(topFiveP) > 0}">
							<ul>
								<c:forEach items="${topFiveP}" var="p">
									<li><a href="/publisher/${p.id}">${p.name}</a> -
										${p.avgscore}</li>
								</c:forEach>
							</ul>
						</c:when>
						<c:otherwise>
							<p class="small-italic">No Publisher available.</p>
						</c:otherwise>
					</c:choose>
				</table>
			</td>
		</tr>
	</table>
	<p><a href="?language=tr"><img src="/img/tr.png" height="20" width="20"></a> | <a href="?language=en"><img src="/img/en.png" height="20" width="20"></a> | <a href="/display-form"><img src="/img/login.png" height="20" width="20"></a></p>
</body>
</html>