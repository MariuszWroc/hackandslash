<%-- 
    Document   : npcs
    Created on : Oct 31, 2015, 12:44:40 PM
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
        <title>Show npcs</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	<div>
	        <h2>List of npcs</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>behaviour</td>
	            </tr>
	            <c:forEach items="${npcs}" var="npc">
	                <tr>
	                    <td>${npc.id}</td>
	                    <td>${npc.behaviour}</td>
	                    <td><a href="<c:url value='/admin/npcs/edit/${npc.id}' />">Edit</a></td>
						<td><a href="<c:url value='/admin/npcs/remove/${npc.id}' />">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
        	<h2>Add/Edit npc</h2>  
	        <c:url var="addAction" value="/admin/npcs/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_npc">  
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
	                        <form:label path="behaviour"><spring:message text="Behaviour"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="behaviour" />
	                    </td> 
	                </tr>  
	                <tr>  
	                    <td colspan="2">
	                    	<c:if test="${!empty one_npc.id}">
	                    		<input type="submit" name="action" value="Edit"/>
	                    	</c:if>
	                    	<c:if test="${empty one_npc.id}">
	                    		<input type="submit" name="action" value="Add"/>
	                    	</c:if>
	                    	<input type="submit" name="action" value="Clear" />
	                    </td>  
	                </tr>  
	            </table>   
	        </form:form> 
        </div>
        	<div>
				<p>
					<a href="${contextPath}/admin/panel">powrót</a>
				</p>
			</div>
    </body>
</html>
