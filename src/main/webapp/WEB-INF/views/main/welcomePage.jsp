<%-- 
    Document   : welcomePage
    Created on : Dec 10, 2015, 11:15:15 PM
    Author     : Jaca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
	</head>
	<body>
		<div>
		   <a href= "#/login"> Login </a>&nbsp;
		   <a href= "#/register"> Register </a>
		</div>
	</body>
</html>
