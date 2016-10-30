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
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set hero attributes</title>
</head>
<body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div align="center">
        	<h2>Set attributes</h2>  
	        <c:url var="addAction" value="/heroTest/add" ></c:url>
	        <form:form id="attributesForm" method="POST" action="${addAction}" commandName="hero">
	        	<table>
        			<tr>
	        			<td>
	        				<form:label path="strength"><spring:message text="Strength"/></form:label>
	        			</td>
						<td>
							<form:input path="strength" type="number" value="${value}" min = "${min}" max = "${max}"/>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<form:label path="dexterity"><spring:message text="Dexterity"/></form:label>
	        			</td>
						<td>
							<form:input path="dexterity" type="number" value="${value}" min = "${min}" max = "${max}"/>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<form:label path="constitution"><spring:message text="Constitution"/></form:label>
	        			</td>
						<td>
							<form:input path="constitution" type="number" value="${value}" min = "${min}" max = "${max}"/>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<form:label path="intelligence"><spring:message text="Intelligence"/></form:label>
	        			</td>
						<td>
							<form:input path="intelligence" type="number" value="${value}" min = "${min}" max = "${max}"/>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>
	        				<form:label path="startingPoints"><spring:message text="Attributes points"/></form:label>
	        		    </td>
	        			<td>
							<form:input path="startingPoints" readonly="true" disabled="true"/>
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
				<a href="${contextPath}/tests">powrót do menu</a>&nbsp;
				<a href="${contextPath}/registerTest">powrót do menu</a>
			</p>
		</div>
</body>
</html>