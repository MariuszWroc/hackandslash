<%-- 
    Document   : register
    Created on : Oct 31, 2015, 12:41:58 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert user (register)</title>
</head>
<title>Registration</title>
</head>
<body>
	<div align="center">
	        <c:url var="addAction" value="/register/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="registerDTO">
			<table>
				<tr>
					<td colspan="2" align="center"><h2>Registration</h2></td>
				</tr>
				<tr>
					<td><form:label path="login">
							<spring:message text="Login" />
						</form:label></td>
					<td><form:input path="login" /></td>
				</tr>
				<tr>
					<td><form:label path="password">
							<spring:message text="Password" />
						</form:label></td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="id">
							<spring:message text="User Role" />
						</form:label></td>
					<td><form:select path="id">
							<form:options items="${roles}" itemLabel="rolename"
								itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
