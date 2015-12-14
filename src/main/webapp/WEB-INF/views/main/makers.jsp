<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
	</head>
	<body>
		<div ng-controller="menuController" flex id="content" ng-cloak class="ng-cloak">
			<md-content layout="column" flex class="md-padding"> 
				<h1>Makers</h1>
			</md-content>
		</div>
	</body>
</html>