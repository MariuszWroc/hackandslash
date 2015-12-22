<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="menuController" class="container" id="login-box">
			<c:url var="addAction" value="/j_spring_security_check" />
		    <form:form action="${addAction}" method="POST" accept-charset="UTF-8">
		        <table>
		            <tr>
		                <td>
		                	<spring:message text="Login:"/>
		                </td>
		                <td>
		                	<input type="text" name="username" value="" required>
		               	</td>
		            </tr>
		            <tr>
		                <td>
		                	<spring:message text="Password:"/>
		                </td>
		                <td>
		                	<input type="password" name="password" required/>
		                </td>
		            </tr>
		            <tr>
		                <td colspan='2'><input name="submit" type="submit"
		                    value="submit" /></td>
		            </tr>
		        </table>
		
		        <input type="hidden" name="${_csrf.parameterName}"
		            value="${_csrf.token}" />
	
	    	</form:form>
	    </div>
	</body>
</html>