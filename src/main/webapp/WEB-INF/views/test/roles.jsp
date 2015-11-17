<%-- 
    Document   : roles
    Created on : Oct 31, 2015, 12:45:09 PM
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
<title>Show users</title>
</head>
<body>
    <div>
        <h2>List of roles</h2>
        <table>
            <tr>
                <td>Id</td>
                <td>Role name</td>
            </tr>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.rolename}</td>
                    <td><a href="<c:url value='/edit/${role.id}' />" >Edit</a></td>
            		<td><a href="<c:url value='/remove/${role.id}' />" >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <h2>One role</h2>
        <table>
            <tr>
                <td>Id</td>
                <td>Role name</td>
            </tr>
            <tr>
                <td>${one_role.id}</td>
                <td>${one_role.rolename}</td>
            </tr>
        </table>
    </div>
    <div>
        <h2>Add/Edit role</h2>  
        <c:url var="addAction" value="/roles/add" ></c:url>
        <form:form method="POST" action="${addAction}" commandName="one_role">  
            <table>  
                <tr>
                	<td>
                        <form:label path="id"><spring:message text="Id"/></form:label>
                    </td>    
                    <td>
                        <form:input path="id" readonly="true" size="8"  disabled="true" />
                        <form:hidden path="id" />
                    </td>  
                </tr>  
                <tr>
                    <td>
                        <form:label path="rolename"><spring:message text="Name"/></form:label>
                    </td>
                    <td>
                        <form:input path="rolename" />
                    </td> 
                </tr>   
                <tr>  
                    <td colspan="2">
                    	<c:if test="${!empty one_role.id}">
                    		<input type="submit" value="Edit"/>
                    	</c:if>
                    	<c:if test="${empty one_role.id}">
                    		<input type="submit" value="Add"/>
                    	</c:if>
                    </td>  
                </tr>  
            </table>   
        </form:form>                    
    </div>
</body>
</html>
