<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css" >
<meta charset="UTF-8">
<title><spring:message code="update" /></title>
</head>
<body>
<h2><spring:message code="update" /> ${game.name} &nbsp;<a href="/menu"><img src="/img/home.png" height="20" width="20"></a></h2>
<form:form method="post" action="/updated/${game.id}" modelAttribute="game">
	<table>
		<tr>
			<td><b><spring:message code="gameName" /> </b></td>
			<td><form:input path="name"/></td>
			<td><form:errors path="name" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td><b><spring:message code="genres" /> </b></td>
			<td>
				
					<c:forEach items="${allGenres}" var="g">
							<form:checkbox path="genreNames" value="${g.name}" label="${g.name}" itemValue="${allGenres}" />
		    		</c:forEach>
		    </td>
				<td>&nbsp;</td>
		</tr>
		<tr>
			<td><b><spring:message code="pname" /> </b></td>
			<td><form:select path="pubName">
					<form:option value="" label="-- Please Select --" />
					<form:option value="2K" label="2K" />
					<form:option value="Bandai Namco Games" label="Bandai Namco Games" />
					<form:option value="Bethesda Softworks" label="Bethesda Softworks" />
					<form:option value="Blizzard" Blizzard="Item" />
					<form:option value="Capcom" label="Capcom" />
					<form:option value="CD Projekt Red" label="CD Projekt Red" />
					<form:option value="Electronic Arts" label="Electronic Arts" />
					<form:option value="Konami" label="Konami" />
					<form:option value="LucasArts" label="LucasArts" />
					<form:option value="Microsoft Game Studios" label="Microsoft Game Studios" />
					<form:option value="Nintendo" label="Nintendo" />
					<form:option value="Rockstar Games" label="Rockstar Games" />
					<form:option value="SEGA" label="SEGA" />
					<form:option value="Sony Interactive Entertainment" label="Sony Interactive Entertainment" />
					<form:option value="Square Enix" label="Square Enix" />
					<form:option value="Ubisoft" label="Ubisoft" />
					<form:option value="Valve" label="Valve" />
				</form:select><br>
			</td>
				<td>&nbsp;</td>
		</tr>
		<tr>
			<td><b><spring:message code="rDate" /> </b></td>
			<td><form:input path="rdate"/></td>
			<td><form:errors path="rdate" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td><b><spring:message code="platforms" /> </b></td>
			<td><form:input path="platforms"/></td>
			<td><form:errors path="platforms" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td><b><spring:message code="rRate" /> </b></td>
			<td><form:input path="ReviewRate"/></td>
			<td><form:errors path="ReviewRate" cssClass="error"></form:errors></td>
		</tr>
				
		<tr>
				<td colspan=3>
					<input type=submit value="Send">
				</td>
		</tr>
		
	</table>
</form:form>
	<p><a href="?language=tr"><img src="/img/tr.png" height="20" width="20"></a> | <a href="?language=en"><img src="/img/en.png" height="20" width="20"></a></p>

</body>
</html>