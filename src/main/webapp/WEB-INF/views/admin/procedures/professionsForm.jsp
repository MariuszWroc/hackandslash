<%-- 
    Document   : register
    Created on : Oct 31, 2015, 12:41:58 PM
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set profession</title>
</head>
<body>
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div align="center">
        	<h2>Hero creator</h2>  
	        <c:url var="addAction" value="/heroTest/redirectToAttributes" ></c:url>
	        <form:form id="heroForm" method="POST" action="${addAction}" commandName="hero">
	        	<table>
	        		<tr>
	        			<td>
	        				<form:label path="profession"><spring:message text="Profession"/></form:label>
	        			</td>
						<td>
							<form:select path="profession">
								<form:options items="${professionEnum}" itemLabel="name" itemValue="id" />
							</form:select>
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