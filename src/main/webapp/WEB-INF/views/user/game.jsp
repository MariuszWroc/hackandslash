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
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="gameController" flex id="content">
		    <md-content layout="column" flex class="md-padding">
		    	<div id="game" class="panel panel-default">
		    		<div class="panel-heading">
		    			<span class="lead">Start game</span>
		    		</div>
					<div class="formcontainer">
					</div>
				</div>
		    </md-content>  
		</div>
	</body>
</html>