<%-- 
    Document   : after logout
    Created on : Oct 29, 2015, 5:24:12 PM
    Author     : mariusz
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<h3>You have successfully logged out</h3>
</html>