<%-- 
    Document   : journals
    Created on : Oct 31, 2015, 12:44:03 PM
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
        <title>Show journals</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	<div>
	    	<h2>List of journals</h2>  
	        <table>
	            <tr>
	                <td>id</td><td>passed</td><td>start date</td>
	            </tr>
	            <c:forEach items="${journals}" var="journal">
	                <tr>
	                    <td>${journal.id}</td>
	                    <td>${journal.passed}</td>
	                    <td>${journal.startDate}</td>
	                    <td><a href="<c:url value='/journals/edit/${journal.id}' />">Edit</a></td>
						<td><a href="<c:url value='/journals/remove/${journal.id}' />">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </table>
    	</div>
        <div>
        	<h2>Add/Edit journal</h2>  
	        <c:url var="addAction" value="/journals/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_journal">  
	            <table>  
	                <tr>  
	                    <td>
	                        <form:label path="id"><spring:message text="ID"/></form:label></td>  
	                    <td>
	                        <form:input path="id" readonly="true" size="8"  disabled="true" />
	                        <form:hidden path="id" />
	                    </td>  
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="passed"><spring:message text="Passed"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="passed" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="startDate"><spring:message text="Start date"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="startDate" />
	                    </td> 
	                </tr> 
	                <tr>  
	                    <td colspan="2">
	                    	<c:if test="${!empty one_journal.id}">
	                    		<input type="submit" value="Edit"/>
	                    	</c:if>
	                    	<c:if test="${empty one_journal.id}">
	                    		<input type="submit" value="Add"/>
	                    	</c:if>
	                    </td>  
	                </tr>  
	            </table>   
	        </form:form> 
        </div>
        	<div>
				<p>
					<a href="${contextPath}/tests">powrót</a>
				</p>
			</div>
    </body>
</html>
