<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div id="footer" layout="row" layout-align="center center">
			<p>
				<a id="link-3" ng-href="#/authors">Authors</a> 
				<a id="link-3" ng-href="#/contact">Contact</a> 
				<a id="link-3" ng-href="#/about">About</a>
			</p>
		</div>
	</body>
</html>