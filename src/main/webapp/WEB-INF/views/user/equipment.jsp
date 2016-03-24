<%-- 
    Document   : equipment
    Created on : Mar 24, 2016, 10:50:50 AM
    Author     : Mariusz
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="gameController" flex id="content">
		    <md-content layout="column" flex class="md-padding">
		    	<div id="game" class="panel panel-default">
		    		<div class="panel-heading">
		    			<span class="lead">Equipment</span>
		    		</div>
					<div class="formcontainer">
					</div>
				</div>
		    </md-content>  
		</div>
	</body>
</html>
