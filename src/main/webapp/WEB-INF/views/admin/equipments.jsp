<%-- 
    Document   : equipments
    Created on : Oct 31, 2015, 11:26:48 AM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show equipments</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	<div>
	        <h2>List of equipments</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>In place</td>
	            </tr>
	            <c:forEach items="${equipments}" var="equipment">
	                <tr>
	                    <td>${equipment.id}</td>
	                    <td>${equipment.inPlace}</td>
	                    <td><a href="<c:url value='/admin/equipments/edit/${equipment.id}' />">Edit</a></td>
						<td><a href="<c:url value='/admin/equipments/remove/${equipment.id}' />">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
            <h2>Add/Edit equipment</h2>  
	        <c:url var="addAction" value="/admin/equipments/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_equipment">  
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
	                        <form:label path="inPlace"><spring:message text="Is in place"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="inPlace" />
	                    </td> 
	                </tr>   
	                <tr>  
	                    <td colspan="2">
	                    	<c:if test="${!empty one_equipment.id}">
	                    		<input type="submit" name="action" value="Edit"/>
	                    	</c:if>
	                    	<c:if test="${empty one_equipment.id}">
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
