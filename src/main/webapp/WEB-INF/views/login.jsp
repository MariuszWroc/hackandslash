<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<body ng-cloak class="ng-cloak">
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<md-dialog aria-label="Logout dialog"> 
			<md-dialog-content>
				<div ng-controller="menuController" class="container" id="login-box">
					<c:url var="loginAction" value="/j_spring_security_check" />
					<form:form action="${loginAction}" method="POST"
						accept-charset="UTF-8">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group form-group-lg">
							<input id="inputLogin" type="text" name="username"
								placeholder="Enter login" class="form-control input-sm" value=""
								required>
						</div>
						<div class="form-group form-group-lg">
							<input id="inputPassword" type="password"
								class="form-control input-sm" name="password"
								placeholder="Enter password" value="" required>
						</div>
						<div style="margin: 0 auto; text-align: center">
							<md-button name="submit" class="md-primary" type="submit"> Log in </md-button>
							<md-button type="button" ng-click="cancel()"> Cancel </md-button>
						</div>
					</form:form>
				</div>
			</md-dialog-content> 
		</md-dialog>
	</body>
</html>