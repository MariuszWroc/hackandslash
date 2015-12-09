<%-- 
    Document   : characters
    Created on : Oct 31, 2015, 11:27:13 AM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div align = "center">
		<h2>Login Page - Test (Old)</h2>
		<c:url var="addAction" value="/admin/login/submit"></c:url>
		<form:form id="loginForm" method="POST" action="${addAction}"
			commandName="user">
			<table>
					<tr>
	                    <td>
	                        <form:label path="login"><spring:message text="Login"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="login" />
	                    </td> 
	                    <td>
	                    	<form:errors path="login" cssClass="error" />
	                    </td>
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="password"><spring:message text="Password"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="password"  type="password"/>
	                    </td> 
	                    <td>
	                    	<form:errors path="password" cssClass="error"/>
	                    </td>
	                </tr>
	                <tr>  
	                    <td colspan="2" align="center">
	                    	<input type="submit" value="Log in"/>
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