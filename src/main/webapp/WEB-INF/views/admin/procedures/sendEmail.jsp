<%-- 
    Document   : email
    Created on : Dec 28, 2015, 03:05:21 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC - Email</title>
	</head>
	<body>
	    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	    <c:url var="addAction" value="/email/send" ></c:url>
	    <div>
	    	<center>
		        <h1>Spring MVC - Send e-mail</h1>
		        <form:form method="POST" action="${addAction}" commandName="email">
		            <table border="0" width="80%">
		                <tr>
		                    <td>Email To:</td>
		                    <td><input type="text" name="sender" size="65" /></td>
		                </tr>
		                <tr>
		                    <td>Subject:</td>
		                    <td><input type="text" name="subject" size="65" /></td>
		                </tr>
		                <tr>
		                    <td>Message:</td>
		                    <td><textarea cols="50" rows="10" name="body"></textarea></td>
		                </tr>            
		                <tr>
		                    <td colspan="2" align="center">
		                        <input type="submit" value="Send E-mail" />
		                    </td>
		                </tr>
		            </table>
		        </form:form>
	    	</center>
	    </div>
	</body>
</html>