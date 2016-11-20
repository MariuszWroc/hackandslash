<%-- 
    Document   : ShowHeroes
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/common.css">
</head>
<body ng-cloak class="ng-cloak">
    <div ng-controller="heroController" flex id="content">
        <md-content layout="column" flex class="md-padding">
            <div ng-include src="'${contextPath}/heroCreateForm'"></div>
            <div ng-include src="'${contextPath}/heroListView'"></div>
	</md-content>
    </div>
</body>
</html>