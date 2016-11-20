<%-- 
    Document   : Play game
    Created on : Dec 21, 2015, 11:21:32 AM
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
                        <div ng-controller="heroController">
                            <div ng-include src="'${contextPath}/heroCreateForm'" ng-if="!heroes.length"></div>
                            <div ng-include src="'${contextPath}/heroListView'" ng-if="heroes.length && heroes.length >= 1"></div>
                        </div>
            	    </md-content>  
		</div>
	</body>
</html>