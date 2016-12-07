<%-- 
    Document   : welcomePage
    Created on : Dec 10, 2015, 11:15:15 PM
    Author     : Jaca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div id="welcome" class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Hello and welcome to the index page of the best hackandslash game to ever grace the world</span>
			</div>
		</div>
	</body>
</html>