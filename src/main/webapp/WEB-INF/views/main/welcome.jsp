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
				<span class="lead">Welcome Page</span>
			</div>
			<div class="formcontainer" layout="row" layout-sm="column" layout-align="center center">
				<md-button class="md-primary" ng-click="login($event)" >Login</md-button>
				<md-button class="md-primary" ng-href="#/register">Register</md-button>
			</div>
		</div>
	</body>
</html>