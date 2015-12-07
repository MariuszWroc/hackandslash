<%-- 
    Document   : characters
    Created on : Oct 31, 2015, 11:27:13 AM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<div>
		<h2>Login Page</h2>
		<c:url var="addAction" value="/login/"></c:url>
		<form:form id="loginForm" method="POST" action="${addAction}"
			commandName="loginUser">
		<table>
									<tr>
								<td><form:label path="login">
										<spring:message text="Login:" />
									</form:label></td>
								<td><form:input path="login" readonly="true"
										disabled="true" /></td>
							</tr>
			<tr>
                    <td>
                        <label>Login:</label>
                    </td>
                    <td>
                        <input type="text" ng-model="user.login"/>
                        <label ng-show="errors.login" class="error">{{errors.login}}</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Password:</label>
                    </td>
                    <td>
                        <input type="password" ng-model="user.password"/>
                        <label ng-show="errors.password" class="error">{{errors.password}}</label>
                    </td>
                </tr>
		</table>
		</form:form>
			<div align="left">
				<p>
					<a href="${contextPath}/admin/panel">powrót</a>
				</p>
			</div>
	</div>