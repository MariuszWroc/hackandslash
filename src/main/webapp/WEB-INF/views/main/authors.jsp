<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="menuController" flex id="content">
			<md-content layout="column" flex class="md-padding">
				<div id="authors" class="panel panel-default">
					<div class="panel-heading">
						<span class="lead">About us</span>
					</div>
					<div class="formcontainer"></div>
				</div>
			</md-content>
		</div>
