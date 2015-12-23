<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<c:url var="logoutUrl" value="${contextPath}/j_spring_security_logout" />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<md-dialog aria-label="Neuer Name">
		<md-dialog-content >
         	<form action="${logoutUrl}" method="POST" id="logoutForm" accept-charset="UTF-8">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div id="logoutButton" class="md-actions" layout="row">
	         		<md-button ng-click="close()"> Cancel </md-button>
	         		<md-button ng-click="close(kind)" class="md-primary"> Log out </md-button>
	   			</div>
			</form>
	   </md-dialog-content>
	</md-dialog>
</body>
</html>