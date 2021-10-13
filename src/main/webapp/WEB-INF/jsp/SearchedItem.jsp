<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>Searched Items</title>
</head>
<body>
	<h2>Searched Items&nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a></h2>
	<table>
		<c:choose>
			<c:when test="${type.type == 'Game'}">
				<c:choose>
					<c:when test="${fn:length(game) > 0}">
						<ul>
							<c:forEach items="${game}" var="g">
								<li><a href="/game/${g.id}/"> ${g.name}</a></li>
							</c:forEach>
						</ul>
					</c:when>
					<c:otherwise>
						<p class="small-italic">No Games found.</p>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when test="${type.type=='Genre'}">
				<c:choose>
					<c:when test="${fn:length(genre) > 0}">
						<ul>
							<c:forEach items="${genre}" var="g">
								<li><a href="/genre/${g.id}/">${g.name}</a></li>
							</c:forEach>
						</ul>
					</c:when>
					<c:otherwise>
						<p class="small-italic">No Genres found.</p>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:when test="${type.type=='Publisher'}">
				<c:choose>
					<c:when test="${fn:length(publisher) > 0}">
						<ul>
							<c:forEach items="${publisher}" var="p">
								<li><a href="/publisher/${p.id}/">${p.name}</a>
								</li>
							</c:forEach>
						</ul>
					</c:when>
					<c:otherwise>
						<p class="small-italic">No Publishers found.</p>
					</c:otherwise>
				</c:choose>
			</c:when>

		</c:choose>

	</table>

</body>
</html>