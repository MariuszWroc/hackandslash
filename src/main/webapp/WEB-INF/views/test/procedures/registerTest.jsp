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
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
<title>Registration</title>
</head>
<body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div align="center">
	        <h2>Register user</h2>  
	        <c:url var="addAction" value="/registerTest/add" ></c:url>
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
	                    	<form:errors path="login" cssclass="error"/>
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
	                    	<form:errors path="password" cssclass="error"/>
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
							<form:select path="gender">
								<form:options items="${genderEnum}" itemLabel="name"
									itemValue="id" />
							</form:select>
						</td>
	                </tr>
	                 <tr>
	                    <td>
	                        <form:label path="age"><spring:message text="Age"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="age" />
	                    </td>
	                    <td>
	                    	<form:errors path="age" cssclass="error"/>
	                    </td> 
	                </tr>
	                <tr>  
	                    <td colspan="2">
	                    	<input type="submit" value="Add"/>
	                    	<input type="reset" value="Clear" />
	                    </td>    
	                </tr>  
	            </table>   
	        </form:form>   
        </div>
		<div align="left">
			<p>
				<a href="${contextPath}/tests">powrót</a>
			</p>
		</div>
</body>
</html>
