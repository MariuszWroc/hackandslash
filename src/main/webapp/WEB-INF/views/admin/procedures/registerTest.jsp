<%-- 
    Document   : register
    Created on : Oct 31, 2015, 12:41:58 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert user (register)</title>
<style>
.error {
	color: #000;
	background-color: #ffEEEE;
	border: 1px solid #ff0000;
}
</style>
</head>
<title>Registration</title>
</head>
<body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div align="center">
	        <h2>Register user</h2>  
	        <c:url var="addAction" value="/admin/registerTest/add" ></c:url>
	        <form:form id="registerForm" method="POST" action="${addAction}" commandName="user">
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
	                    <td>
	                        <form:label path="email" ><spring:message text="E-mail"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="email" type="email"/>
	                    </td>
	                    <td>
	                    	<form:errors path="email" cssClass="error"/>
	                    </td> 
	                </tr>    
	                <tr>
	                    <td>
	                        <form:label path="firstname" ><spring:message text="First name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="firstname" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="lastname"><spring:message text="Last name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="lastname" />
	                    </td> 
	                </tr>
	                <tr>
	                    <td>
	                        <form:label path="gender"><spring:message text="Gender"/></form:label>
	                    </td>
						<td>
							<form:select path="gender" >
								<form:option value=""/>
								<form:options items="${genderEnum}" itemLabel="name"
									itemValue="id"/>
							</form:select>
						</td>
	                </tr>
	                 <tr>
	                    <td>
	                        <form:label path="age"><spring:message text="Age"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="age" type="number"  min = "1"/>
	                    </td>
	                </tr>
	                <tr>  
	                    <td colspan="2">
	                    	<input type="submit" value="Add"/>
	                    	<input type="reset" value="Clear"/>
	                    </td>    
	                </tr>  
	            </table>   
	        </form:form>   
        </div>
		<div align="left">
			<p>
				<a href="${contextPath}/admin/panel">powrót</a>
			</p>
		</div>
</body>
</html>
