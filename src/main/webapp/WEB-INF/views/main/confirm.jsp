<%-- 
    Document   : confirm
    Created on : Mar 24, 2016, 11:35:07 AM
    Author     : Mariusz
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
				<span class="lead">Confirmation</span>
			</div>
			<div class="formcontainer" layout-align="center center">
                            <label>Email send</label>
			</div>
		</div>
	</body>
</html>
